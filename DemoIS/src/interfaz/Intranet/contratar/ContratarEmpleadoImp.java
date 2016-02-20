package interfaz.Intranet.contratar;


import interfaz.Intranet.contratar.DAOs.DAOContratarEmpleado;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ContratarEmpleadoImp implements AplicationServiceContratarEmpleado{
	
	@Override
	public void darAltaEmpleado(DAOContratarEmpleado baseDeDatos, TransferObjectContratarEmpleado datosEmpleado) throws Exception {
		if(!baseDeDatos.estaEmpleadoContratado(datosEmpleado))
			baseDeDatos.guardarEmpleadoContratado(datosEmpleado);
		else throw new Exception();
	}
	
	@Override
	public void mostrarCurriculum() {
		JFrame noHechoFrame = new JFrame();
		JOptionPane.showMessageDialog(noHechoFrame, "Este metodo aun esta en desarrollo.", "En desarrollo.", JOptionPane.WARNING_MESSAGE);
	}
}
