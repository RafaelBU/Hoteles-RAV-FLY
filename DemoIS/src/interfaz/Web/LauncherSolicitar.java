package interfaz.Web;

import interfaz.LauncherPadre;
import interfaz.Web.reserva.VentanaSolicitar;

import java.awt.EventQueue;

public class LauncherSolicitar extends LauncherPadre{
	
	private static VentanaSolicitar ventanaSolicitar = new VentanaSolicitar();
		
	public LauncherSolicitar()
	{
			
	}
		
	/**
	 * Metodo que sirve para hacer visible la ventana
	 */
	public static void lanzaVentana() 
	{	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				ventanaSolicitar.setVisible(true);
			}
		});
	}

		/**
		 * Método que llama al cierraVentana de su clase padre, se encarga de cerrar la ventana
		 * (sin que acabe toda la ejecución del programa)
		 */
	public static void cierraVentana()
	{
		cierraVentana(ventanaSolicitar);
	}

}
