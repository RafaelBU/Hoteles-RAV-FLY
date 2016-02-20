package interfaz.Web.reserva.paneles;



import java.awt.BorderLayout;

import javax.swing.JPanel;

public class PanelSolicitar extends JPanel{

	private static final long serialVersionUID = 1L; 
	
	private PanelDatosCliente panelDatosCliente; 
	private PanelDatosReserva panelDatosReserva; 
	
	public PanelSolicitar()
	{
		panelDatosCliente = new PanelDatosCliente();	
		panelDatosReserva = new PanelDatosReserva();
	
		this.add(panelDatosReserva, BorderLayout.NORTH);
		this.add(panelDatosCliente, BorderLayout.CENTER);
		
	}
	
}
