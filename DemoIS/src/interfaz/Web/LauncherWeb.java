package interfaz.Web;

import interfaz.LauncherPadre;

import java.awt.EventQueue;

/**
 * Lanzador que sirve generar la ventana de web
 * 
 */
public class LauncherWeb extends LauncherPadre {
	
	private static VentanaWeb ventanaWeb = new VentanaWeb();
	
	public LauncherWeb()
	{
		
	}
	
	/**
	 * Metodo que sirve para hacer visible la ventana
	 */
	public static void lanzaVentana() 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				ventanaWeb.setVisible(true);
			}
			 });
		}


	/**
	 * Método que llama al cierraVentana de su clase padre, se encarga de cerrar la ventana
	 * (sin que acabe toda la ejecución del programa)
	 */
	public static void cierraVentana()
	{
		cierraVentana(ventanaWeb);
	}

}
