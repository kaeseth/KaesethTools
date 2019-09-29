package com.kaeseth.tools.transaction.exception;
/**
 * 执行器实际返回的对象和目标对象不同
 * @author kaeseth
 *
 */
public class NonExpectedException extends RuntimeException {
	public NonExpectedException(String aim,String real) {
		super("this worker run result("+real+") diff aim("+aim+").");
	}
}
