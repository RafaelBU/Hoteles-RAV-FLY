package interfaz.Intranet.login.DAOs;




import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DAOLoginImp implements DAOLogin{
	private boolean accesoCorrecto;
	private String fileName;
	private FileReader fileReader;
	private BufferedReader buffer;
	
	public DAOLoginImp(String fileName){
		this.fileName = fileName;
		buffer = null;
		this.accesoCorrecto = false;
	}

	public void comprobarDatos(String user, String password) {
		String cadena;
		
		try {
			this.fileReader = new FileReader(this.fileName);
			this.buffer = new BufferedReader(this.fileReader);
			
			while ( (cadena = buffer.readLine()) != null && this.accesoCorrecto == false){
				String []comprobacion = cadena.split(" ");
				if(comprobacion[0].equals(user) && comprobacion[1].equals(password)){
					this.accesoCorrecto = true;
				}
			}
			
			this.fileReader.close();
			this.buffer.close();
		} catch (IOException e) {
			
		}
		
	}

	public boolean accesoIntranet() {
		return this.accesoCorrecto;
	}
}
