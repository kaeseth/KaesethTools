package kaeseth.tools.tuple;

public class Tuple7<T1, T2, T3, T4, T5, T6,T7> extends Tuple6<T1, T2, T3, T4, T5, T6> {
	private T7 t7;
	public Tuple7(T1 t1,T2 t2,T3 t3,T4 t4,T5 t5,T6 t6,T7 t7) {
		super(t1, t2, t3, t4, t5, t6);
		this.t7=t7;
	}
	public T7 getT7() {
		return t7;
	}
	public void setT7(T7 t7) {
		this.t7 = t7;
	}
	@Override
	public String toString() {
		return super.toString()+",[T7:"+this.getT7().toString()+"]";
	}
}
