package interfaz.Intranet.contratar;

public class TransferObjectContratarEmpleado {
	private String nombre;
	private String apellidos;
	private String dni;
	private String numSegSocial;
	
	/*Funciones observadoras.*/
	public String obtenerNombre(){
		return this.nombre;
	}
	public String obtenerApellidos(){
		return this.apellidos;
	}
	public String obtenerDNI(){
		return this.dni;
	}
	public String obtenerNumeroDeSeguridadSocial(){
		return this.numSegSocial;
	}
	
	/*Funciones mutadoras.*/
	public void introducirCambiarNombre(String nombre){
		this.nombre = nombre;
	}
	public void introducirCambiarApellidos(String apellidos){
		this.apellidos = apellidos;
	}
	public void introducirCambiarDNI(String dni){
		this.dni = dni;
	}
	public void introducirCambiarNumeroDeSeguridadSocial(String numSegSocial){
		this.numSegSocial = numSegSocial;
	}
}
