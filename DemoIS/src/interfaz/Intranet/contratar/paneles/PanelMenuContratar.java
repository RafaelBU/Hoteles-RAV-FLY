package interfaz.Intranet.contratar.paneles;

import interfaz.Intranet.LauncherContratar;
import interfaz.Intranet.LauncherIntranet;
import interfaz.Intranet.LauncherMenuContratar;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelMenuContratar extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	private JButton visualizarCurriculums;
	private JButton consultarCurriculum;
	private JButton realizarContratacion;
	private JPanel panelNorte;
	private JPanel panelCentro;
	private JPanel panelSur;
	private JButton botonVolver;
	private JPanel prueba = new JPanel();
	Color color = new Color(222, 231, 249);
	
	public PanelMenuContratar()
	{
		visualizarCurriculums = new JButton("Visualizar curriculums");
		consultarCurriculum = new JButton("Consultar curriculums");
		realizarContratacion = new JButton("Contratar");
		panelNorte = new JPanel();
		panelCentro = new JPanel();
		panelSur = new JPanel();
		botonVolver = new JButton("Volver");
		
		panelNorte.setBackground(color);
		panelCentro.setBackground(color);
		panelSur.setBackground(color);
		prueba.setBackground(color);
		
		panelNorte.setBorder(BorderFactory.createTitledBorder("Visualizar"));
		panelCentro.setBorder(BorderFactory.createTitledBorder("Consular"));
		panelSur.setBorder(BorderFactory.createTitledBorder("Contratar"));
		
		this.setLayout(new GridLayout(4,1));
		
		panelNorte.add(visualizarCurriculums);
		panelCentro.add(consultarCurriculum);
		panelSur.add(realizarContratacion);
		prueba.add(botonVolver);
		
		visualizarCurriculums.addActionListener(this);
		consultarCurriculum.addActionListener(this);
		realizarContratacion.addActionListener(this);
		botonVolver.addActionListener(this);
		
		this.add(panelNorte);
		this.add(panelCentro);
		this.add(panelSur);
		this.add(prueba);
	}

	@Override
	public void actionPerformed(ActionEvent event) 
	{
		if((event.getSource() == visualizarCurriculums) 
				|| (event.getSource() == consultarCurriculum ))
		{
			JOptionPane.showMessageDialog(this, "No disponible en el flujo del programa", "Información", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(event.getSource() == realizarContratacion)
		{
			//Acceder a contratarPersonal
			LauncherMenuContratar.cierraVentana();
			LauncherContratar.lanzaVentana();
		}
		else if(event.getSource() == botonVolver)
		{
			LauncherMenuContratar.cierraVentana();
			LauncherIntranet.lanzaVentana();
		}//Salir al inicio de la intranet
		
	}

}
