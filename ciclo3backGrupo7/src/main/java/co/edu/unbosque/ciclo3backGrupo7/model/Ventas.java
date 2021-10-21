package co.edu.unbosque.ciclo3backGrupo7.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ventas {
	
	@Id
	private Long codigo_venta;
	private Long cedula_cliente;
	private Long cedula_usuario;
	private double iva_venta;
	private double total_venta;
	private double valor_venta;
	
	public double getTotal_venta() {
		return total_venta;
	}
	public void setTotal_venta(double total_venta) {
		this.total_venta = total_venta;
	}
	public double getValor_venta() {
		return valor_venta;
	}
	public void setValor_venta(double valor_venta) {
		this.valor_venta = valor_venta;
	}
	public double getIva_venta() {
		return iva_venta;
	}
	public void setIva_venta(double iva_venta) {
		this.iva_venta = iva_venta;
	}
	public Long getCodigo_venta() {
		return codigo_venta;
	}
	public void setCodigo_venta(Long codigo_venta) {
		this.codigo_venta = codigo_venta;
	}
	public Long getCedula_cliente() {
		return cedula_cliente;
	}
	public void setCedula_cliente(Long cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}
	public Long getCedula_usuario() {
		return cedula_usuario;
	}
	public void setCedula_usuario(Long cedula_usuario) {
		this.cedula_usuario = cedula_usuario;
	}
	
	
	
	
	
	

}
