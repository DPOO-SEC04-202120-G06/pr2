package modelo;

public class cliente {
	private String nombre;
	private String ciudad;
	private String sexo;
	private String E_civil;
	private double puntos;
	public cliente(String thenombre, String theciudad, String thesexo,String theE_civil, double thepuntos)
	{
		this.nombre = thenombre;
		this.ciudad = theciudad;
		this.sexo = thesexo;
		this.E_civil = theE_civil;
		this.puntos = thepuntos;
	}
	public String getnombre()
	{
		return nombre;
		
	}
	public String getciudad()
	{
		return ciudad;
		
	}
	public String getsexo()
	{
		return sexo;
		
	}
	public String getE_civil()
	{
		return E_civil;
		
	}
	public double getpuntos()
	{
		return puntos;
		
	}
	public void setpuntos(double npuntos)
	{
		this.puntos= npuntos;
	}
	
}
