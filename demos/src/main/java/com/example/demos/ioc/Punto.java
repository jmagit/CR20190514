package com.example.demos.ioc;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



//@Component
@Scope("prototype")
public class Punto {
	private int x = 1, y = 2;
	
	
	public Punto() {}
	
	public Punto(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Punto [x=" + x + ", y=" + y + "]";
	}
	
	
}
