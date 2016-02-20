package interfaz.Web;

import interfaz.PanelPadre;
import interfaz.Intro.LauncherVentana;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Clase que representan el panel de inicio
 * 
 */
public class PanelWeb extends PanelPadre implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	/**
	 * Componentes necesarios para el panel
	 */
	private JPanel panelAux;
	private JButton anularReserva;
	private JButton solicitarReserva;
	private JButton empleo;
	private JButton salir;
	
	/**
	 * Constructor que sirve para inicializar todo lo relacionado con el panel de la web
	 * 
	 * @param url String que indica la ruta de la imagen
	 */
	public PanelWeb(String url)
	{
		super(url);//Constructor de la clase padre
		this.setLayout(new BorderLayout());
		
		solicitarReserva = new JButton("Solicitar Reserva");
		anularReserva = new JButton("Anular Reserva");
		empleo = new JButton("Trabaja con nosotros");
		salir = new JButton("Salir");
		
		panelAux = new JPanel();
		
		panelAux.add(solicitarReserva);
		panelAux.add(anularReserva);
		panelAux.add(empleo);
		panelAux.add(salir);
		
		this.add(panelAux, BorderLayout.SOUTH);
		
		solicitarReserva.addActionListener(this);
		anularReserva.addActionListener(this);
		empleo.addActionListener(this);
		salir.addActionListener(this);
	}
	
	/**
	 * Llama al metodo paint de la clase padre, que sirve para "pintar" la imagen seleccionada en el panel
	 */
	public void pintar()
	{
		super.paint(g);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == solicitarReserva)
		{
			LauncherWeb.cierraVentana();
			LauncherSolicitar.lanzaVentana();
		}
		else if(e.getSource() == anularReserva)
		{
			JOptionPane.showMessageDialog(this, "No disponible en el flujo del programa", "Información", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getSource() == empleo)
		{
			JOptionPane.showMessageDialog(this, "No disponible en el flujo del programa", "Información", JOptionPane.INFORMATION_MESSAGE);
		}
		else{
			//volvemos al menu principal
			LauncherWeb.cierraVentana();
			LauncherVentana.lanzaVentana();
		}
		
	}
}
