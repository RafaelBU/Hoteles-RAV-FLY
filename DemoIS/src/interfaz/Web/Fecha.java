package interfaz.Web;

public class Fecha {

	int dia; 
	int mes; 
	int anyo; 
	
	public int getDia()
	{
		return dia;
	}
	
	public int getMes()
	{
		return mes;
	}
	
	public int getAnno()
	{
		return anyo;
	}
	
	public void setDia(int dia)
	{
		this.dia = dia;
	}
	
	public void setMes(int mes)
	{
		this.mes = mes;
	}
	
	public void setAnyo(int anyo)
	{
		this.anyo = anyo;
	}
	
	public String toString()
	{
		return dia + "/" + mes + "/" + anyo;
	}
}
