package com.kaeseth.tools.transaction.exception;

/**
 * 执行器队列未能完全执行成功
 * @author kaeseth
 *
 */
public class WorkerListNotFullyException extends RuntimeException {
	public WorkerListNotFullyException(int aim,int real) {
		super("this worker list real succeed is "+real+", but aim is "+aim+".");
	}
}
