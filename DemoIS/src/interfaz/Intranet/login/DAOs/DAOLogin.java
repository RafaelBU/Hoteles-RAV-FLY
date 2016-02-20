package interfaz.Intranet.login.DAOs;

public interface DAOLogin {
	public abstract void comprobarDatos(String user, String password);
	public abstract boolean accesoIntranet();
}
