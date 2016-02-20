package interfaz.Intranet.contratar.paneles;

import interfaz.Intranet.LauncherContratar;
import interfaz.Intranet.LauncherMenuContratar;
import interfaz.Intranet.contratar.ContratarEmpleadoImp;
import interfaz.Intranet.contratar.TransferObjectContratarEmpleado;
import interfaz.Intranet.contratar.DAOs.DAOContratarEmpleadoImp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelContratar extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	private JLabel nombre;
	private JLabel apellidos;
	private JLabel DNI;
	private JLabel nSeguridadSocial;
	private JTextField textoNombre;
	private JTextField textoApellidos;
	private JTextField textoDNI;
	private JTextField textoSeguridadSocial;
	
	private JPanel panelNombre;
	private JPanel panelApellidos;
	private JPanel panelDNI;
	private JPanel panelSeguridadSocial;
	private JPanel panelOpciones;
	
	private JButton finalizarCont;
	private JButton volver;
	private TransferObjectContratarEmpleado transfer;
	private ContratarEmpleadoImp servicio;
	
	Color color = new Color(222, 231, 249);


	public PanelContratar()
	{
		transfer = new TransferObjectContratarEmpleado();
		
		nombre = new JLabel("Nombre");
		apellidos = new JLabel("Apellidos");
		DNI = new JLabel("DNI");
		nSeguridadSocial = new JLabel("Nº seguridad social");
		
		textoNombre = new JTextField();
		textoNombre.setMaximumSize(new Dimension(Integer.MAX_VALUE, textoNombre.getMinimumSize().height));
		
		textoApellidos = new JTextField();
		textoApellidos.setMaximumSize(new Dimension(Integer.MAX_VALUE, textoApellidos.getMinimumSize().height));
		
		textoDNI = new JTextField();
		textoDNI.setMaximumSize(new Dimension(Integer.MAX_VALUE, textoDNI.getMinimumSize().height));
		
		textoSeguridadSocial = new JTextField();
		textoSeguridadSocial.setMaximumSize(new Dimension(Integer.MAX_VALUE, textoSeguridadSocial.getMinimumSize().height));
		
		finalizarCont = new JButton("Contratar");
		volver = new JButton("Volver");
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(color);
		
		panelNombre = new JPanel();
		panelNombre.setBackground(color);
		panelNombre.setLayout(new BoxLayout(panelNombre, BoxLayout.X_AXIS));
		panelNombre.add(nombre);
		panelNombre.add(textoNombre);
		
	    panelApellidos = new JPanel();
	    panelApellidos.setBackground(color);
	    panelApellidos.setLayout(new BoxLayout(panelApellidos, BoxLayout.X_AXIS));
		panelApellidos.add(apellidos);
		panelApellidos.add(textoApellidos);
		
	    panelDNI = new JPanel();
	    panelDNI.setLayout(new BoxLayout(panelDNI, BoxLayout.X_AXIS));
	    panelDNI.setBackground(color);
		panelDNI.add(DNI);
		panelDNI.add(textoDNI);
		
		panelSeguridadSocial = new JPanel();
		panelSeguridadSocial.setBackground(color);
		panelSeguridadSocial.setLayout(new BoxLayout(panelSeguridadSocial, BoxLayout.X_AXIS));
		panelSeguridadSocial.add(nSeguridadSocial);
		panelSeguridadSocial.add(textoSeguridadSocial);
			
		panelOpciones = new JPanel();
		panelOpciones.setBackground(color);
		panelOpciones.setLayout(new BoxLayout(panelOpciones, BoxLayout.X_AXIS));
		panelOpciones.add(finalizarCont);
		panelOpciones.add(volver);
		
		
		this.add(Box.createGlue());
		this.add(panelNombre);
		
		this.add(Box.createGlue());
		this.add(panelApellidos);
		
		this.add(Box.createGlue());
		this.add(panelDNI);
		this.add(Box.createGlue());
		
		this.add(panelSeguridadSocial);
		this.add(Box.createGlue());
		
		this.add(panelOpciones);
		
		
		finalizarCont.addActionListener(this);
		volver.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent event) 
	{
		if(event.getSource() == finalizarCont )
		{
			//enviar datos al transfer
			transfer.introducirCambiarNombre(textoNombre.getText());
			transfer.introducirCambiarApellidos(textoApellidos.getText());
			transfer.introducirCambiarDNI(textoDNI.getText());
			transfer.introducirCambiarNumeroDeSeguridadSocial(textoSeguridadSocial.getText());
			
			servicio = new ContratarEmpleadoImp();
			try {
				servicio.darAltaEmpleado(new DAOContratarEmpleadoImp(), transfer);
				JOptionPane.showMessageDialog(this, "Contratado con exito", "Info", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Ya esta el empleado", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		else{
			LauncherContratar.cierraVentana();
			LauncherMenuContratar.lanzaVentana();
		}
	}

}
