package kaeseth.tools.transaction;

import java.util.List;
import java.util.function.Supplier;
import org.springframework.transaction.annotation.Transactional;
import kaeseth.tools.transaction.exception.NonExpectedException;
import kaeseth.tools.transaction.exception.WorkErrorException;
import kaeseth.tools.transaction.exception.WorkerListNotFullyException;

/**
 * if do same sql, please @Transactional to this class exec methods.
 * @author kaeseth
 * @version
 *
 */

public class TransactionRunner {
	
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
