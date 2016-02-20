package interfaz.Intranet;

import interfaz.LauncherPadre;
import interfaz.Intranet.login.VentanaInicioIntranet;

import java.awt.EventQueue;

/**
 * Lanzador que sirve generar la ventana del acceso a Intranet
 * 
 */
public class LauncherIntranet extends LauncherPadre{

	private static VentanaInicioIntranet ventanaIntranet = new VentanaInicioIntranet();
	
	public LauncherIntranet()
	{
		
	}
	
	/**
	 * Metodo que sirve para hacer visible la ventana
	 */
	public static void lanzaVentana() 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				ventanaIntranet.setVisible(true);
			}
			 });
	}


	/**
	 * Método que llama al cierraVentana de su clase padre, se encarga de cerrar la ventana
	 * (sin que acabe toda la ejecución del programa)
	 */
	public static void cierraVentana()
	{
		cierraVentana(ventanaIntranet);
	}
}
