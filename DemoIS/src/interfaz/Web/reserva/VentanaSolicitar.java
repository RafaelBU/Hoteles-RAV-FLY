package interfaz.Web.reserva;

//import interfaz.Web.reserva.solicitar.paneles.PanelSolicitar;

import interfaz.Web.reserva.paneles.PanelSolicitar;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class VentanaSolicitar  extends JFrame{

private static final long serialVersionUID = 1L;
	
	private PanelSolicitar panel;
	
	/**
	 * Constructor que configura la ventana
	 */
	public VentanaSolicitar()
	{
		super("Solicitar Reserva");
		this.setSize(650,450);
		
		panel = new PanelSolicitar();
		panel.setLayout(new GridLayout(0,1));	
		this.add(panel);
		
		centrarVentana();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	
	private void centrarVentana() 
	 {
        // Se obtienen las dimensiones en pixels de la pantalla.
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        // Se obtienen las dimensiones en pixels de la ventana.
        Dimension ventana = getSize();
        // Una cuenta para situar la ventana en el centro de la pantalla.
        setLocation((pantalla.width - ventana.width) / 2,
                        (pantalla.height - ventana.height) / 2);
	 }
}
