package interfaz.Intranet.contratar.DAOs;

import interfaz.Intranet.contratar.TransferObjectContratarEmpleado;


public interface DAOContratarEmpleado {
	void guardarEmpleadoContratado(TransferObjectContratarEmpleado datosEmpleado);
	boolean estaEmpleadoContratado(TransferObjectContratarEmpleado datosEmpleado);
}
