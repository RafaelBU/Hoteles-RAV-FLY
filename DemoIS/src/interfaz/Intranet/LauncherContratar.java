package interfaz.Intranet;

import interfaz.LauncherPadre;
import interfaz.Intranet.contratar.ventanas.VentanaContratar;

import java.awt.EventQueue;

public class LauncherContratar extends LauncherPadre {

private static VentanaContratar ventanaContr = new VentanaContratar();
	
	public LauncherContratar()
	{
		
	}
	
	/**
	 * Metodo que sirve para hacer visible la ventana
	 */
	public static void lanzaVentana() 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				ventanaContr.setVisible(true);
			}
			 });
	}
	
	/**
	 * Método que llama al cierraVentana de su clase padre, se encarga de cerrar la ventana
	 * (sin que acabe toda la ejecución del programa)
	 */
	public static void cierraVentana()
	{
		cierraVentana(ventanaContr);
	}

}
