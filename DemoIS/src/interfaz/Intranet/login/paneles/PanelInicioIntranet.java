package interfaz.Intranet.login.paneles;

import interfaz.PanelPadre;
import interfaz.Intranet.LauncherIntranet;
import interfaz.Intranet.LauncherMenuContratar;
import interfaz.Intranet.login.ApplicationServiceLogin;
import interfaz.Intranet.login.TransferLogin;
import interfaz.Intro.LauncherVentana;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Clase que representan el panel de acceso a Intranet
 * 
 */
public class PanelInicioIntranet extends PanelPadre implements ActionListener{

	private static final long serialVersionUID = 1L;

	/**
	 * Componentes visuales y paneles necesarios
	 */
	private JButton entrar;
	private JButton salir;
	private JLabel usuario;
	private JLabel contrasena;
	private JTextField textoUsuario;
	//JPASSWORDFIELD hace que sea una entrada de contraseña
	private JPasswordField textoContrasena;
	private JPanel panelDatos;
	private JPanel panelBotones;
	private JPanel panelAux;
	private TransferLogin transferLogin;
	private ApplicationServiceLogin servicio;

	/**
	 * Constructor que sirve para inicializar todo lo relacionado con el panel de intranet
	 * 
	 * @param url String que indica la ruta de la imagen
	 */
	public PanelInicioIntranet(String url)
	{
		 
		super(url);//Constructor de la clase padre
		
		transferLogin = new TransferLogin();
		panelDatos = new JPanel();
		panelBotones = new JPanel();
		panelAux = new JPanel();
		
		panelAux.setLayout(new BorderLayout());
		
		this.setLayout(new BorderLayout());
		
		entrar = new JButton("Entrar");
		salir = new JButton("Salir");
		
		usuario = new JLabel("Usuario");
		contrasena = new JLabel("Contrasena");
		
		textoUsuario = new JTextField();
		textoContrasena = new JPasswordField();
		
		//Hace que la contraseña muestre ** metas lo que metas, pero guarda lo que metas
		textoContrasena.setEchoChar('*');
		textoUsuario.setPreferredSize(new Dimension(100,40));
		textoContrasena.setPreferredSize(new Dimension(100,40));
		
		panelDatos.add(usuario);
		panelDatos.add(textoUsuario);
		panelDatos.add(contrasena);
		panelDatos.add(textoContrasena);
		panelDatos.setBackground(Color.white);
		
		panelBotones.add(entrar);
		panelBotones.add(salir);
		panelBotones.setBackground(Color.white);
		
		panelAux.add(panelDatos, BorderLayout.NORTH);
		panelAux.add(panelBotones, BorderLayout.SOUTH);
		
		this.add(panelAux, BorderLayout.SOUTH);
		
		entrar.addActionListener(this);
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
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == entrar)
		{
			//entrar en el menu de intranet
			transferLogin.setUser(textoUsuario.getText());
			transferLogin.setPassword(textoContrasena.getText());
			
			servicio = new ApplicationServiceLogin(transferLogin);
			
				if(servicio.realizarLogin())
				{
					JOptionPane.showMessageDialog(this, "Acceso permitido", "Información", JOptionPane.INFORMATION_MESSAGE);
					LauncherIntranet.cierraVentana();
					LauncherMenuContratar.lanzaVentana();
				}
				else 
				{
					JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
				}
		}
		else{
			//Volvemos al menu principal
			LauncherIntranet.cierraVentana();
			LauncherVentana.lanzaVentana();
		}
		
	}

}
