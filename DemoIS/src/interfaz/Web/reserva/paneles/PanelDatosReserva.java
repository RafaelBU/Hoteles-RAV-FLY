package interfaz.Web.reserva.paneles;

//import interfaz.Web.reserva.TranferReserva;

import interfaz.Web.Fecha;
import interfaz.Web.reserva.ApplicationServiceReserva;
import interfaz.Web.reserva.TransferCliente;
import interfaz.Web.reserva.TransferReserva;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelDatosReserva extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private JTextField personas, noches, pensiones, habitaciones; 
	private JTextField dia, mes, anyo; 
	private TransferReserva transferReserva; 
	private TransferCliente transferCl;
	private Fecha fecha;
	private ApplicationServiceReserva servicio;
	
	public PanelDatosReserva()
	{
		//super();
		
		transferReserva = new TransferReserva();
		fecha = new Fecha();
		
		this.setBorder(BorderFactory.createTitledBorder("Datos Reserva"));
		this.setLayout(new GridLayout(5,0));
		this.add(panelTipoHab()); 
		this.add(panelTipoPension());
		this.add(panelNPersonasNoches()); 
		this.add(panelFecha()); 
		this.add(panelAceptar());
	}
	
	private JPanel panelTipoHab()
	{
		JPanel panel = new JPanel(); 
		panel.setLayout(new FlowLayout());
		
		habitaciones = new JTextField(16);
		panel.add(new JLabel(" Tipo de habitacion "));
		panel.add(habitaciones);
	
		return panel; 
	}
	
	private JPanel panelTipoPension()
	{	
		JPanel panel = new JPanel(); 
		panel.setLayout(new FlowLayout());
		
		pensiones = new JTextField(16);
		panel.add(new JLabel(" Tipo de pension "));
		panel.add(pensiones);
		
		return panel; 
	}
	
	private JPanel panelNPersonasNoches()
	{	
		JPanel panel = new JPanel(); 
		panel.setLayout(new FlowLayout());
		
		noches = new JTextField(4);
		panel.add(new JLabel(" Nº de noches  "));
		panel.add(noches);
		
		personas = new JTextField(4);
		panel.add(new JLabel(" Nº de personas "));
		panel.add(personas);
		
		return panel; 
	}
	
	private JPanel panelFecha()
	{
		JPanel panel = new JPanel(); 
		panel.setLayout(new FlowLayout());
		
		panel.add(new JLabel(" Fecha "));
		
		dia = new JTextField(4);
		panel.add(dia);
		mes = new JTextField(4);
		panel.add(mes);
		anyo = new JTextField(4);
		panel.add(anyo);
	
		return panel; 
	}
	
	private JPanel panelAceptar()
	{
		JButton aceptar = new JButton("Aceptar");
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		panel.add(aceptar);	
		aceptar.addActionListener(this);
		
		return panel; 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String n_noches, n_personas; 
		
		if ((pensiones.getText().length()!= 0) && (habitaciones.getText().length()!= 0))
		{
			try{
				
				transferReserva.setHab(habitaciones.getText());
				transferReserva.setPension(pensiones.getText());
				
				n_noches = noches.getText();
				
				transferReserva.setN_noches(n_noches);
				
				n_personas = personas.getText();
				
				transferReserva.setN_personas(n_personas);
				
				fecha.setDia(Integer.parseInt(dia.getText()));
				fecha.setMes(Integer.parseInt(mes.getText()));
				fecha.setAnyo(Integer.parseInt(anyo.getText()));
				
				transferReserva.setFecha(fecha);
				
				servicio = new ApplicationServiceReserva(transferReserva, transferCl);
				
				if ( ! servicio.realizarReserva(transferReserva))
				{
					JOptionPane.showMessageDialog(this, "Fecha no valida");
				}
				else{
					JOptionPane.showMessageDialog(this, "Datos de reserva validos, por favor complete los datos personales");
					
					//Desabilitamos los Jtext para que no nos modifiquen los datos 
					personas.setEditable(false);
					noches.setEditable(false);
					pensiones.setEditable(false);
					habitaciones.setEditable(false);
					dia.setEditable(false);
					mes.setEditable(false);
					anyo.setEditable(false);
					
					//actualizamos los datos del fichero con la reserva
					servicio.actualizarDatosReserva(transferReserva);
					
				}
			} catch (NumberFormatException e1){
				JOptionPane.showMessageDialog(this, " Datos no validos ");
			}
		}			
		else{
			JOptionPane.showMessageDialog(this, "Por favor, introduzca todos los datos");
			
		}	
	}
	
}
