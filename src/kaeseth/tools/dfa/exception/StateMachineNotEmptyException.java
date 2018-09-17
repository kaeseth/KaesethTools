package kaeseth.tools.dfa.exception;

public class StateMachineNotEmptyException extends RuntimeException {
	public StateMachineNotEmptyException() {
		super("status machine not empty, can't create a new StatusMachine.");
	}
}
