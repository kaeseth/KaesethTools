package kaeseth.tools.dfa.exception;

/**
 * 状态机内存在不合法的单元
 * @author kaeseth
 *
 */
public class StateMachineStatusErrorException extends RuntimeException {
	public StateMachineStatusErrorException() {
		super("StateMachine status error!");
	}
}
