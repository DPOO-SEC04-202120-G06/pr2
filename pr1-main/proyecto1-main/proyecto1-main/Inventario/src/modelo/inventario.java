package modelo;

import java.util.HashMap;
import java.util.ArrayList;



public class inventario {
	private HashMap<String, lote> inventario;
	public inventario() 
	{
		this.inventario = new HashMap<String, lote>();
	}
	public boolean verificarDisponibilidad(String nombreProducto)
	{
		boolean contiene = inventario.containsKey(nombreProducto);
		return contiene;
	}
	public void Comprarproducto(String nombreProducto) {
	lote Lote = inventario.get(nombreProducto);
	Lote.comprar();
	inventario.replace(nombreProducto, Lote);
	}
	public void eliminarLote(String nombreProducto)
	{
		inventario.remove(nombreProducto);
	}
	public void agregarLotes(ArrayList<lote> Lotes)
	{
		double size = Lotes.size();
		for(int i = 0; i <= size-1; i++)
		{
			lote Lote = Lotes.get(i) ;
			String nombre = Lote.getproducto() ;
			inventario.put(nombre, Lote);
		}
	}
	
	public HashMap<String, lote> getinventario()
	{
		return inventario;
	}
	}
