package com.kaeseth.tools.transaction;

import java.util.List;
import java.util.function.Supplier;
import org.springframework.transaction.annotation.Transactional;
import com.kaeseth.tools.transaction.exception.NonExpectedException;
import com.kaeseth.tools.transaction.exception.WorkErrorException;
import com.kaeseth.tools.transaction.exception.WorkerListNotFullyException;

/**
 * 用于执行某些不可分割的任务，比如SQL语句。
 * @author kaeseth
 * @version 1.0
 *
 */

public class TransactionRunner {
	
	/**
	 * 获取一个执行器
	 * @param aim 目标对象
	 * @param worker 执行器
	 * @param <T> 目标对象的类型
	 * @return 执行器
	 */
	public static <T> Supplier<Boolean> of(T aim,Supplier<T> worker){
		return ()->{
			T real=worker.get();
			if(real.equals(aim)) {
				return true;
			}else {
				throw new NonExpectedException(aim.toString(), real.toString());
			}
		};
	}
	
	/**
	 * 执行单个执行器
	 * @param aim 目标对象
	 * @param worker 执行器
	 * @param <T> 目标对象的类型
	 * @return 实际返回对象
	 */
	@Transactional
	public static <T> T exec(T aim,Supplier<T> worker) {
		T real;
		try {
			real=worker.get();
		}catch (Exception e) {
			throw new WorkErrorException(0, e);
		}
		if(real.equals(aim)) {
			return real;
		}else {
			throw new NonExpectedException(aim.toString(), real.toString());
		}
	}
	
	/**
	 * 批量执行多个执行器
	 * @param workerList 执行器队列
	 * @return 执行器队列中成功执行的执行器数量
	 */
	@Transactional
	public static Integer exec(List<Supplier<Boolean>> workerList) {
		if(workerList==null||workerList.isEmpty()) {
			throw new NullPointerException("this worker list is empty.");
		}else {
			int count=0;
			try {
				for(Supplier<Boolean> loop:workerList) {
					Boolean succeed=false;
					succeed=loop.get();
					if(succeed) {
						count++;
					}else {
						break;
					}
				}
			}catch (Exception e) {
				throw new WorkErrorException(count, e);
			}
			if(count==workerList.size()) {
				return new Integer(count);
			}else {
				throw new WorkerListNotFullyException(workerList.size(), count);
			}
		}
	}
	
}
