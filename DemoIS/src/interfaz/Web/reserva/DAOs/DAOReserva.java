package interfaz.Web.reserva.DAOs;

import interfaz.Web.Fecha;
import interfaz.Web.reserva.TransferCliente;
import interfaz.Web.reserva.TransferReserva;

public interface DAOReserva {
	public boolean comprobarFecha(Fecha fecha);
	public boolean comprobarDatosCliente(TransferCliente cliente);
	public boolean comprobarDatosReserva(TransferReserva reserva);
	public void actualizarDatosReserva(TransferReserva reserva) throws Exception;
	public void actualizaDatosCliente(TransferCliente cliente) throws Exception;
	public TransferReserva datosReserva(TransferReserva reserva);
}
