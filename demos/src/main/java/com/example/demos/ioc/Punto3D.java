package com.example.demos.ioc;

import org.springframework.stereotype.Component;

//@Component
public class Punto3D extends Punto {
	private int z=3;

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	@Override
	public String toString() {
		return "Punto3D [x=" + getX() + ", y=" + getY() + ", z=" + z + "]";
	}
	
}
