package interfaz.Web.reserva;

import interfaz.Web.Fecha;
import interfaz.Web.reserva.DAOs.DAOReservaImp;

public class ApplicationServiceReserva{

	private String fichero;
	private DAOReservaImp Daoreserva;
	private TransferReserva transferR;
	
	public ApplicationServiceReserva(TransferReserva transferR, TransferCliente transferCl)
	{
		fichero = "Reservas.txt";
		
		Daoreserva = new DAOReservaImp(fichero);
		this.transferR = transferR;
	}
	
	public boolean realizarReserva(TransferReserva reserva) 
	{
		if(Daoreserva.comprobarFecha(reserva.getFecha()) && Daoreserva.comprobarDatosReserva(transferR))
		{
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean comprobarDatosReserva()
	{
		return Daoreserva.comprobarDatosReserva(transferR);
	}
	
	public boolean comprobarDatosCliente(TransferCliente transferCl)
	{
		return Daoreserva.comprobarDatosCliente(transferCl);
	}
	
	public boolean comprobarFecha(Fecha fecha)
	{
		return Daoreserva.comprobarFecha(fecha);
	}
	
	public void actualizarDatosReserva(TransferReserva reserva)
	{
		try {
			Daoreserva.actualizarDatosReserva(reserva);
		} catch (Exception e) {
			
		}
	}
	
	public void actualizarDatosCliente(TransferCliente cliente)
	{
		try {
			Daoreserva.actualizaDatosCliente(cliente);
		} catch (Exception e) {
			
		}
	}
}
