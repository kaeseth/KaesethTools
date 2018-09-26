package kaeseth.tools.tuple;

public class Tuple2<T1,T2> {
	private T1 t1;
	private T2 t2;
	
	public Tuple2(T1 t1, T2 t2) {
		this.t1 = t1;
		this.t2 = t2;
	}
	
	public T1 getT1() {
		return t1;
	}
	public void setT1(T1 t1) {
		this.t1 = t1;
	}
	public T2 getT2() {
		return t2;
	}
	public void setT2(T2 t2) {
		this.t2 = t2;
	}
	
	@Override
	public String toString() {
		return "[T1:"+this.getT1().toString()+"],[T2:"+this.getT2().toString()+"]";
	}
}
