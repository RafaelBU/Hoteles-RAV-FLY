package interfaz.Intranet.contratar.DAOs;

import interfaz.Intranet.contratar.TransferObjectContratarEmpleado;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DAOContratarEmpleadoImp implements DAOContratarEmpleado {
	private String contratarUsuarioFichero = "Contrato.txt";
	private String[] baseDeDatos;
	private int tamano;
	private int capacidad;
	
	/**
	 * Constructora de la implementacion del DAO Contratar Empleado
	 */
	public DAOContratarEmpleadoImp() {
		this.capacidad = 100;
		this.tamano = 0;
		this.baseDeDatos = new String[this.capacidad];
		try{
			Scanner sc = new Scanner(new File("Contrato.txt"));
			while(sc.hasNext()){
				String cadena = sc.nextLine();
				this.baseDeDatos[this.tamano] = cadena;
				this.tamano++;
				if(this.tamano>=this.capacidad)
					redimensionarBaseDeDatos(this.tamano + 40);
			}
			sc.close();
		}catch(FileNotFoundException e){
			
		}
	}
	@Override
	/**
	 * Busca el nombre y apellidos del empleado en la base de datos para evitar posibles coincidencias. Observadora parcial.
	 */
	public boolean estaEmpleadoContratado(TransferObjectContratarEmpleado datosEmpleado) {
		boolean encontrado = false; String nombreLeido, apellidosLeidos;
		int i = 0; 
		while(i < this.tamano && !encontrado){
			nombreLeido = this.baseDeDatos[i];
			i++;
			apellidosLeidos = this.baseDeDatos[i];
			i++;
			if(nombreLeido.equals(datosEmpleado.obtenerNombre())&& apellidosLeidos.equals(datosEmpleado.obtenerApellidos())){
				encontrado = true;
			}
			i+=2;
		}
		return encontrado;
	}

	@Override
	/**
	 * Guarda los datos del empleado contratado.
	 */
	public void guardarEmpleadoContratado(TransferObjectContratarEmpleado datosEmpleado) {
		try{	
			
			FileWriter writer = new FileWriter(contratarUsuarioFichero);
			int i = 0;
			while(i < this.tamano){
				writer.write(baseDeDatos[i]);
				writer.write("\r\n");
				i++;
			}
			
			if(this.tamano>=this.capacidad)
				redimensionarBaseDeDatos(this.tamano + 40);
			
			writer.write(datosEmpleado.obtenerNombre());
			this.baseDeDatos[i] = datosEmpleado.obtenerNombre(); i++;
			this.tamano++;
			writer.write("\r\n");
			
			writer.write(datosEmpleado.obtenerApellidos());
			this.baseDeDatos[i] = datosEmpleado.obtenerApellidos(); i++;
			this.tamano++;
			writer.write("\r\n");
			
			writer.write(datosEmpleado.obtenerDNI());
			this.baseDeDatos[i] = datosEmpleado.obtenerDNI(); i++;
			this.tamano++;
			writer.write("\r\n");
			
			writer.write(datosEmpleado.obtenerNumeroDeSeguridadSocial());
			this.baseDeDatos[i] = datosEmpleado.obtenerNumeroDeSeguridadSocial();
			this.tamano++;
			writer.write("\r\n");
			
			writer.close();
		}catch(IOException e){}
	}
	
	private void redimensionarBaseDeDatos(int nuevoTamano){
		String[] bAux = new String[nuevoTamano];
		int i = 0;
		while(i < this.baseDeDatos.length){
			bAux[i] = this.baseDeDatos[i];
			i++;
		}
		this.capacidad = nuevoTamano;
		this.baseDeDatos = bAux;
	}
	
	public void obtenerDireccionDeFichero(String fichero){
		this.contratarUsuarioFichero = fichero;
	}
}
