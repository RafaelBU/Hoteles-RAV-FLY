package interfaz.Intranet.login;

import java.awt.Dimension;
import java.awt.Toolkit;

import interfaz.PanelPadre;
import interfaz.Intranet.login.paneles.PanelInicioIntranet;

import javax.swing.JFrame;

/**
 * Clase que representa la ventana de inicio de la intranet
 * 
 */
public class VentanaInicioIntranet extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private PanelPadre padre;
	
	/**
	 * Constructor que configura la ventana
	 */
	public VentanaInicioIntranet()
	{
		
		super("https://www.EmpleadosRavFly.com");
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setAlwaysOnTop(true);
		//this.setSize(700, 548);
		centrarVentana();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		padre = new PanelInicioIntranet("Imagenes/intranet.png");
		
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
