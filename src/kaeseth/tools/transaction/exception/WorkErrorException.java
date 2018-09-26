package kaeseth.tools.transaction.exception;

/**
 * 执行器执行出错
 * @author kaeseth
 * @version 1.0
 */
public class WorkErrorException extends RuntimeException {
	public WorkErrorException(int index,Throwable e) {
		super("this worker in index "+index+" running error!");
		this.addSuppressed(e);
	}
}
