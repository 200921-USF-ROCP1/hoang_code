package com.revature.classes;

public class JsonClass {
	private int i;
	private String s;
	private boolean b;
	
	public JsonClass(int i, String s, boolean b) {
		this.i = i;
		this.s = s;
		this.b = b;
	}
	//When serializing data, make sure to have a no params constructor if any
	//other constructors are defined.
	public JsonClass() {
	}
	
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}
	public boolean isB() {
		return b;
	}
	public void setB(boolean b) {
		this.b = b;
	}
}
