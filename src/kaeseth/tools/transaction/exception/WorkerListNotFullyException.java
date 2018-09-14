package kaeseth.tools.transaction.exception;

public class WorkerListNotFullyException extends RuntimeException {
	public WorkerListNotFullyException(int aim,int real) {
		super("this worker list real succeed is "+real+", but aim is "+aim+".");
	}
}
