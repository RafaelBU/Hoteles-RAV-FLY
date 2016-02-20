package interfaz.Intranet.login;

public class TransferLogin {
	private String usuer;
	private String password;
	
	public TransferLogin(){
		this.usuer = null;
		this.password = null;
	}
	
	public void setUser(String user){
		this.usuer = user;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getUser(){
		return this.usuer;
	}
	
	public String getPassword(){
		return this.password;
	}

}
