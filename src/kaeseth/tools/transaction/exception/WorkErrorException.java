package kaeseth.tools.transaction.exception;

/**
 * A worker in list or only one running error.
 * @author kaeseth
 * @version 1.0
 */
public class WorkErrorException extends RuntimeException {
	public WorkErrorException(int index,Throwable e) {
		super("this worker in index "+index+" running error!");
		this.addSuppressed(e);
	}
}
