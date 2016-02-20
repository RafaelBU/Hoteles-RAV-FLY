package interfaz.Web.reserva.paneles;

//import interfaz.Web.reserva.PanelSalir;

import interfaz.Web.PanelSalir;
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

public class PanelDatosCliente extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	private JTextField nombre, apellido, dni, paypal; 
	private PanelSalir panelSalir; 
	private ApplicationServiceReserva servicio;
	private TransferCliente transferCliente;
	private TransferReserva transferReserva;
	
	public PanelDatosCliente()
	{
		panelSalir = new PanelSalir(); 
		transferCliente = new TransferCliente();
		transferReserva = new TransferReserva();
		
		this.setBorder(BorderFactory.createTitledBorder("Datos Cliente"));
		this.setLayout(new GridLayout(5,0));
		this.add(panelNombreApellidos()); 
		this.add(panelDni());
		this.add(panelPaypal());
		this.add(panelAceptar());
		this.add(panelSalir);
	}
	
	private JPanel panelNombreApellidos()
	{
		JPanel panel = new JPanel(); 
		panel.setLayout(new FlowLayout());
		
		nombre = new JTextField(16);
		panel.add(new JLabel("Nombre "));
		panel.add(nombre);
		
		apellido = new JTextField(16);	
		panel.add(new JLabel("Apellido "));
		panel.add(apellido);
		
		return panel; 
	}
	
	private JPanel panelDni()
	{	
		JPanel panel = new JPanel(); 
		panel.setLayout(new FlowLayout());
		
		dni = new JTextField(16); 
		panel.add(new JLabel("Dni ")); 
		panel.add(dni);
		
		return panel; 
	}
	
	private JPanel panelPaypal()
	{	
		JPanel panel = new JPanel(); 
		panel.setLayout(new FlowLayout());
		
		paypal = new JTextField(16); 
		panel.add(new JLabel(" Paypal ")); 
		panel.add(paypal);
		
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
		
		transferCliente.setNombre(nombre.getText());
		transferCliente.setApellido(apellido.getText());
		transferCliente.setDni(dni.getText());
		transferCliente.setN_cuenta(paypal.getText());
		
		servicio = new ApplicationServiceReserva(transferReserva, transferCliente);
		
		if (servicio.comprobarDatosCliente(transferCliente))
		{
			JOptionPane.showMessageDialog(this, "La reserva se ha realizado con exito");
			
			//Deshabilitar Jtext para que no se modifiquen datos
			nombre.setEditable(false);
			apellido.setEditable(false);
			dni.setEditable(false);
			paypal.setEditable(false);
			
			//Actualizar el fichero con los datos del cliente
			servicio.actualizarDatosCliente(transferCliente);
		}	
		else
			JOptionPane.showMessageDialog(this, "Fallo en la operacion de reserva");
		
	}
}
