package com.kaeseth.tools.tuple;

public class Tuple3<T1,T2,T3> extends Tuple2<T1, T2> {
	private T3 t3;
	public Tuple3(T1 t1,T2 t2,T3 t3) {
		super(t1, t2);
		this.t3=t3;
	}
	public T3 getT3() {
		return t3;
	}
	public void setT3(T3 t3) {
		this.t3 = t3;
	}
	@Override
	public String toString() {
		return super.toString()+",[T3:"+this.getT3().toString()+"]";
	}
}
