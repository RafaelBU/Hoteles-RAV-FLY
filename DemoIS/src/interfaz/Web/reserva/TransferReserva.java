package interfaz.Web.reserva;

import interfaz.Web.Fecha;
import interfaz.Web.TipoHabitacion;
import interfaz.Web.TipoPension;

public class TransferReserva {
	
	// ATRIBUTOS 
	
	private String n_noches; 
	private String n_personas; 
	private TipoPension pension; 
	private TipoHabitacion hab; 
	private Fecha fecha;
	private TransferCliente cliente; 
	
	// METODOS 
	
	public String getN_noches() {
		return n_noches;
	}
	public void setN_noches(String n_habitaciones) {
		this.n_noches = n_habitaciones;
	}
	
	public String getN_personas() {
		return n_personas;
	}
	public void setN_personas(String n_personas) {
		this.n_personas = n_personas;
	}
	
	public TipoPension getPension() {
		return pension;
	}
	public void setPension(String pension) {
		if(pension.equals("0") )
		{
			this.pension = TipoPension.mediaPension;
		}
		else if(pension.equals("1"))
		{
			this.pension = TipoPension.pensionCompleta;
		}
		else if(pension.equals("2"))
		{
			this.pension = TipoPension.alojamiento;
		}
		
	}
	
	public TipoHabitacion getHab() {
		return hab;
	}
	public void setHab(String hab) {
		if(hab.equals("0" ))
		{
			this.hab = TipoHabitacion.simple;
		}
		else if(hab.equals("1"))
		{
			this.hab = TipoHabitacion.doble;
		}
		else if(hab.equals("2"))
		{
			this.hab = TipoHabitacion.triple;
		}
		else if(hab.equals("3"))
		{
			this.hab = TipoHabitacion.suite;
		}
	}
	
	public Fecha getFecha() {
		return fecha;
	}
	public void setFecha(Fecha fecha) {
		this.fecha = fecha;
	}
	
	public TransferCliente getCliente() {
		return cliente;
	}
	public void setCliente(TransferCliente cliente) {
		this.cliente = cliente;
	}
	
	public String toString(TipoPension pension)
	{
		String tipo="";
		
		switch(pension)
		{
		case alojamiento: tipo = "Tipo de pension : alojamiento";
							break;
		case mediaPension : tipo = "Tipo de pension : media pension";
							break;
		case pensionCompleta: tipo = "Tipo de pension : pension completa";
							break;
			
		}
		
		return tipo;
	}
	
	public String toString(TipoHabitacion habitacion)
	{
		String tipo="";
		
		switch(habitacion)
		{
		case simple: tipo = "Tipo de habitacion : simple";
							break;
		case doble : tipo = "Tipo de habitacion : doble";
							break;
		case triple : tipo = "Tipo de habitacion : triple";
							break;
		case suite : tipo = "Tipo de habitacion : suite";
							break;
			
		}
		
		return tipo;
	}

	
}
