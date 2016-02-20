package interfaz.Intro;

import interfaz.LauncherPadre;

import java.awt.EventQueue;

/**
 * Lanzador que sirve generar la ventana de inicio
 * 
 */
public class LauncherVentana extends LauncherPadre {
	
	private static VentanaInicio ventanaInicio = new VentanaInicio();
	
	public LauncherVentana()
	{
		
	}
	
	/**
	 * Metodo que sirve para hacer visible la ventana
	 */
	public static void lanzaVentana() 
	{	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				ventanaInicio.setVisible(true);
			}
			 });
	}

	/**
	 * Método que llama al cierraVentana de su clase padre, se encarga de cerrar la ventana
	 * (sin que acabe toda la ejecución del programa)
	 */
	public static void cierraVentana()
	{
		cierraVentana(ventanaInicio);
	}

}


