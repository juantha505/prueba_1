package co.edu.unbosque.ciclo3backGrupo7.model;

import java.io.Serializable;

public class Consecutivo implements Serializable{
	
private int id;
	
	public Consecutivo(int id) {
		super();
		this.id=id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}



