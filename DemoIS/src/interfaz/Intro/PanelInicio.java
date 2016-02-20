package interfaz.Intro;

import interfaz.PanelPadre;
import interfaz.Intranet.LauncherIntranet;
import interfaz.Web.LauncherWeb;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Clase que representan el panel de inicio
 * 
 */
public class PanelInicio extends PanelPadre implements ActionListener {
	
	Color color = new Color(222, 231, 249); 
	private static final long serialVersionUID = 1L;
	
	/**
	 * Componentes necesarios para el panel
	 */
	private JPanel panelAux;
	private JButton inicioWeb;
	private JButton inicioIntranet;
	private JButton salir;

	/**
	 * Constructor que sirve para inicializar todo lo relacionado con el panel de inicio
	 * 
	 * @param url String que indica la ruta de la imagen
	 */
	public PanelInicio(String url)
	{
		super(url);//Constructor de la clase padre
		
		inicioWeb = new JButton("Iniciar Web");
		inicioIntranet = new JButton("Acceder a la intranet");
		salir = new JButton("Salir de la aplicacion");
		
		panelAux = new JPanel();
		this.setLayout(new BorderLayout());
		
		panelAux.add(inicioWeb);
		panelAux.add(inicioIntranet);
		panelAux.add(salir);
		panelAux.setBackground(color);
		this.add(panelAux, BorderLayout.SOUTH);
		
		inicioWeb.addActionListener(this);
		inicioIntranet.addActionListener(this);
		salir.addActionListener(this);
	}
	
	/**
	 * Llama al metodo paint de la clase padre, que sirve para "pintar" la imagen seleccionada en el panel
	 */
	public void pintar()
	{
		this.paint(g);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == inicioWeb)
		{
			//Acceder a la web
			LauncherVentana.cierraVentana();
			LauncherWeb.lanzaVentana();
		}
		else if(event.getSource() == inicioIntranet)
		{
			//Acceder a menu intranet
			LauncherVentana.cierraVentana();
			LauncherIntranet.lanzaVentana();
		}
		else{
			int i = JOptionPane.showConfirmDialog(this, "¿Realmente desea salir de la aplicacion?","Confirmar Salida",JOptionPane.YES_NO_OPTION);
			
			if(i == 0)
			{
				System.exit(0);
			}
		}//Salir de la aplicacion
		
	}

}
