package kaeseth.tools.dfa.exception;

/**
 * 状态机不为空，无法初始化
 * @author kaeseth
 * @deprecated 已被遗弃
 */
public class StateMachineNotEmptyException extends RuntimeException {
	public StateMachineNotEmptyException() {
		super("status machine not empty, can't create a new StatusMachine.");
	}
}
