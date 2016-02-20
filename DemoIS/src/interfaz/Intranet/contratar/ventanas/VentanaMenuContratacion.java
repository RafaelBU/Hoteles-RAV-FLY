package interfaz.Intranet.contratar.ventanas;


import interfaz.Intranet.contratar.paneles.PanelMenuContratar;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class VentanaMenuContratacion extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private PanelMenuContratar menuContratar;
	
	public VentanaMenuContratacion()
	{
		super("Menu Contratacion");
		this.setSize(700, 548);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menuContratar = new PanelMenuContratar();
		
		centrarVentana();
		
		this.add(menuContratar);
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
