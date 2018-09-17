package kaeseth.tools.dfa.exception;

public class StateMachineStatusErrorException extends RuntimeException {
	public StateMachineStatusErrorException() {
		super("StateMachine status error!");
	}
}
