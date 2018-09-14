package kaeseth.tools.transaction.exception;

public class NonExpectedException extends RuntimeException {
	public NonExpectedException(String aim,String real) {
		super("this worker run result("+real+") diff aim("+aim+").");
	}
}
