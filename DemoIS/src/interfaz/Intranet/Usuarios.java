package interfaz.Intranet;

public class Usuarios {

	private Usuario [] plantilla;
	int numPlantilla;
	
	public Usuarios()
	{
		plantilla = new Usuario[100];
		plantilla[0]= new Usuario("pedro", "12345");
		numPlantilla++;
		plantilla[1] = new Usuario("manolo", "54321");
		numPlantilla++;
	}
	
	public boolean buscar(String usuario, String contrasena) 
	{		
		for (int i =0; i < this.numPlantilla;i++)
		{
			if (plantilla[i].getUsuario().equals(usuario) && plantilla[i].getContrasena().equals(contrasena))
			{
				return true;
			}
		}
		return false;
	}

}
