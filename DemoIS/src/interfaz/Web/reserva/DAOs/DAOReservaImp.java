package interfaz.Web.reserva.DAOs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

import interfaz.Web.Fecha;
import interfaz.Web.reserva.TransferCliente;
import interfaz.Web.reserva.TransferReserva;

public class DAOReservaImp implements DAOReserva {
	
	private String fichero;
	private String [] datos;
	private int capacidad;
	private int tamano;
	
	public DAOReservaImp(String file)
	{
		this.fichero = file;
		this.capacidad = 100;
		this.tamano = 0;
		this.datos = new String[this.capacidad];
		try{
			Scanner sc = new Scanner(new File(fichero));
			while(sc.hasNext()){
				String cadena = sc.nextLine();
				this.datos[this.tamano] = cadena;
				this.tamano++;
				if(this.tamano>=this.capacidad)
					capacidad+= 40;
			}
			sc.close();
		}catch(FileNotFoundException e){
			
		}
	}
	
	public boolean comprobarFecha(Fecha fecha) 
	{	
		int d = fecha.getDia();
		int m = fecha.getMes();
		int a = fecha.getAnno();
		
		if (((d>0) && (d<=31)) && ((m>0) && (m<=12)) && (a>=2014))
		{
			return true;
		}
		else{
			return false;
		}
		
	}

	@Override
	public boolean comprobarDatosCliente(TransferCliente cliente) 
	{
		if(cliente.getNombre().length() == 0 || cliente.getApellido().length() == 0 
				|| cliente.getDni().length() == 0 || cliente.getN_cuenta().length() == 0)
		{
			return false;
		}
		else{
			return true;
		}
	}
	
	@Override
	public boolean comprobarDatosReserva(TransferReserva reserva) 
	{
		if(reserva.getN_noches().length() == 0 || reserva.getN_personas().length() == 0)
		{
			return false;
		}
		else{
			return true;
		}
	}

	@Override
	public void actualizarDatosReserva(TransferReserva reserva) throws Exception 
	{
		FileWriter writer = new FileWriter(fichero);
		int i = 0;
		
		while(i < this.tamano)
		{
			writer.write(datos[i]);
			writer.write("\r\n");
			i++;
		}
		
		writer.write(reserva.toString(reserva.getHab()));
		this.datos[i] = reserva.toString(reserva.getHab()); 
		i++;
		this.tamano++;
		writer.write("\r\n");
		
		writer.write(reserva.toString(reserva.getPension()));
		this.datos[i] = reserva.toString(reserva.getPension()); 
		i++;
		this.tamano++;
		writer.write("\r\n");
		
		writer.write("Numero de noches: " + reserva.getN_noches());
		this.datos[i] = "Numero de noches: " + reserva.getN_noches(); 
		i++;
		this.tamano++;
		writer.write("\r\n");
		
		writer.write("Numero de personas: " + reserva.getN_personas());
		this.datos[i] = "Numero de personas: " + reserva.getN_personas(); 
		i++;
		this.tamano++;
		writer.write("\r\n");
		
		writer.write("Fecha: " + reserva.getFecha().toString());
		this.datos[i] = "Fecha: " + reserva.getFecha().toString(); 
		i++;
		this.tamano++;
		writer.write("\r\n");
		
		writer.close();
		
	}

	@Override
	public TransferReserva datosReserva(TransferReserva reserva) 
	{
		return reserva;
	}

	@Override
	public void actualizaDatosCliente(TransferCliente cliente) throws Exception 
	{
		FileWriter writer = new FileWriter(fichero);
		int i = 0;
		
		while(i < this.tamano)
		{
			writer.write(datos[i]);
			writer.write("\r\n");
			i++;
		}
		
		writer.write("Nombre: " + cliente.getNombre());
		this.datos[i] = "Nombre: " + cliente.getNombre();
		i++;
		this.tamano++;
		writer.write("\r\n");
		
		writer.write("Apellidos: " + cliente.getApellido());
		this.datos[i] = "Apellidos: " + cliente.getApellido();
		i++;
		this.tamano++;
		writer.write("\r\n");
		
		writer.write("DNI: " + cliente.getDni());
		this.datos[i] = "DNI: " + cliente.getDni();
		i++;
		this.tamano++;
		writer.write("\r\n");
		
		writer.write("Cuenta Paypal: " + cliente.getN_cuenta());
		this.datos[i] = "Cuenta Paypal: " + cliente.getN_cuenta(); 
		i++;
		this.tamano++;
		writer.write("\r\n");
		//writer.write("\r\n");
		
		writer.close();
	}

}
