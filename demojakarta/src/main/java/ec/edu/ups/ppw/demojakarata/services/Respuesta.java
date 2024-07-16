package ec.edu.ups.ppw.demojakarata.services;

public class Respuesta {
	
	private int codigo;
	private String mensaje;
	
	public static int OK =1;
	public static int error = 99;
	
	public Respuesta(int codigo, String mensaje) {
		super();
		this.codigo = codigo;
		this.mensaje = mensaje;
	}
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	

}
