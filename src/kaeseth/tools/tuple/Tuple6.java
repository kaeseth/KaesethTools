package kaeseth.tools.tuple;

public class Tuple6<T1, T2, T3, T4, T5,T6> extends Tuple5<T1, T2, T3, T4, T5> {
	private T6 t6;
	public Tuple6(T1 t1,T2 t2,T3 t3,T4 t4,T5 t5,T6 t6) {
		super(t1, t2, t3, t4, t5);
		this.t6=t6;
	}
	public T6 getT6() {
		return t6;
	}
	public void setT6(T6 t6) {
		this.t6 = t6;
	}
	@Override
	public String toString() {
		return super.toString()+",[T6:"+this.getT6().toString()+"]";
	}
}
