package interfaz.Intranet.contratar.ventanas;


import java.awt.Dimension;
import java.awt.Toolkit;

import interfaz.Intranet.contratar.paneles.PanelContratar;

import javax.swing.JFrame;

public class VentanaContratar extends JFrame{
	
private static final long serialVersionUID = 1L;
	
	private PanelContratar contratar;
	
	public VentanaContratar()
	{
		super("Realizar Contratacion");
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contratar = new PanelContratar();
		
		centrarVentana();
		this.add(contratar);
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
