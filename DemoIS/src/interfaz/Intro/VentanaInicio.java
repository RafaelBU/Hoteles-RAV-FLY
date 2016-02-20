package interfaz.Intro;

import java.awt.Dimension;
import java.awt.Toolkit;

import interfaz.PanelPadre;

import javax.swing.JFrame;

/**
 * Clase que representa la ventana de inicio de la aplicación
 * 
 */
public class VentanaInicio extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private PanelPadre padre;

	/**
	 * Constructor que configura la ventana
	 */
	public VentanaInicio()
	{
		super("Bienvenidos a hoteles RAV-FLY");
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setAlwaysOnTop(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		centrarVentana();
		padre = new PanelInicio("Imagenes/Intro.png");
		
		
		this.add(padre);
		
		
	}
	
	  private void centrarVentana() {
          // Se obtienen las dimensiones en pixels de la pantalla.
          Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
          // Se obtienen las dimensiones en pixels de la ventana.
          Dimension ventana = getSize();
          // Una cuenta para situar la ventana en el centro de la pantalla.
          setLocation((pantalla.width - ventana.width) / 2,
                          (pantalla.height - ventana.height) / 2);
  }

}
