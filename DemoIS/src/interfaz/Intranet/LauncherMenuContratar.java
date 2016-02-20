package interfaz.Intranet;

import java.awt.EventQueue;

import interfaz.LauncherPadre;
import interfaz.Intranet.contratar.ventanas.VentanaMenuContratacion;

public class LauncherMenuContratar extends LauncherPadre{
	
	private static VentanaMenuContratacion ventanaMenuContr = new VentanaMenuContratacion();
	
	public LauncherMenuContratar()
	{
		
	}
	
	/**
	 * Metodo que sirve para hacer visible la ventana
	 */
	public static void lanzaVentana() 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				ventanaMenuContr.setVisible(true);
			}
			 });
	}
	
	/**
	 * Método que llama al cierraVentana de su clase padre, se encarga de cerrar la ventana
	 * (sin que acabe toda la ejecución del programa)
	 */
	public static void cierraVentana()
	{
		cierraVentana(ventanaMenuContr);
	}

}
