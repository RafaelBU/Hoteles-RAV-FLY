package interfaz.Intranet;

public class Usuario {

	String usuario;
	String contrasena;
	int max;
	
	public Usuario(String usuario, String contrasena)
	{
		this.contrasena = contrasena;
		this.usuario = usuario;
	}
	
	public void setUsuario(String usuario) 
	{
		this.usuario = usuario;
	}
	
	public void setContrasena(String contrasena)
	{
		this.contrasena = contrasena;
	}
	
	public String getUsuario() 
	{
		return usuario;
	}
	
	public String getContrasena() {
		return contrasena;
	}
}
