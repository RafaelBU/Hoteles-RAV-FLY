package interfaz.Intranet.login;

import interfaz.Intranet.login.DAOs.DAOLoginImp;


public class ApplicationServiceLogin {
	private String fileName = "Login.txt";
	private DAOLoginImp dao;
	private TransferLogin transfer;

	public ApplicationServiceLogin(TransferLogin transfer){
		this.dao = new DAOLoginImp(this.fileName);
		this.transfer = transfer;
	}
	
	public boolean realizarLogin(){
		dao.comprobarDatos(transfer.getUser(), transfer.getPassword());
		return dao.accesoIntranet();
	}
}
