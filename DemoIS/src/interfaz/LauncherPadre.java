package interfaz;

import javax.swing.JFrame;

/**
 * Clase que representa un lanzador "padre" del que pueden heredar el resto de lanzadores especificos
 * 
 */
public class LauncherPadre {
	
	public LauncherPadre()
	{
		
	}
	
	/**
	 * Cierra la ventana indicada
	 * 
	 * @param ventana ventana que queremos cerrar
	 */
	public static void cierraVentana(JFrame ventana)
	{
		ventana.dispose();
	}

}
