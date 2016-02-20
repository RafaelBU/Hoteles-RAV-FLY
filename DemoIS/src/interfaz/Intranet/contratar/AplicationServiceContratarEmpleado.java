package interfaz.Intranet.contratar;

import interfaz.Intranet.contratar.DAOs.DAOContratarEmpleado;


public interface AplicationServiceContratarEmpleado {
	void darAltaEmpleado(DAOContratarEmpleado baseDeDatos, TransferObjectContratarEmpleado datosEmpleado) throws Exception;
	void mostrarCurriculum();
}
