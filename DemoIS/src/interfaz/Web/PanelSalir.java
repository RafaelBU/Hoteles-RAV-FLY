package interfaz.Web;

import interfaz.Web.LauncherWeb;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelSalir extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private JButton volver; 

	public PanelSalir()
	{		
		this.add(panelVolver()); 
	}

	private JPanel panelVolver()
	{	
		volver = new JButton("Volver"); 
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		panel.add(volver);
		volver.addActionListener(this); 
		
		return panel; 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		LauncherSolicitar.cierraVentana();
		LauncherWeb.lanzaVentana();	
	}
}
