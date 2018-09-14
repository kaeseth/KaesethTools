package test;

import java.util.ArrayList;
import java.util.function.Supplier;
import kaeseth.tools.TupleUtil;
import kaeseth.tools.transaction.TransactionRunner;
import kaeseth.tools.tuple.Tuple2;

public class MainClass {

	public static void main(String[] args) {
		Supplier<Integer> func=()->{
			throw new RuntimeException("自定义异常");
		};
		ArrayList<Supplier<Boolean>> funcList=new ArrayList<>();
		funcList.add(TransactionRunner.of(12, func));
		TransactionRunner.exec(funcList);
	}

}
