package kaeseth.tools.tuple;

public class Tuple4<T1,T2,T3,T4> extends Tuple3<T1, T2, T3> {
	private T4 t4;
	public Tuple4(T1 t1,T2 t2,T3 t3,T4 t4) {
		super(t1, t2, t3);
		this.t4=t4;
	}
	public T4 getT4() {
		return t4;
	}
	public void setT4(T4 t4) {
		this.t4 = t4;
	}
	@Override
	public String toString() {
		return super.toString()+",[T4:"+this.getT4().toString()+"]";
	}
}
