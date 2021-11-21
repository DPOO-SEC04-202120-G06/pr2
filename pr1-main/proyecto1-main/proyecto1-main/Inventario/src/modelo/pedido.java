package modelo;

import java.util.ArrayList;

public class pedido {
	private ArrayList<producto> Productos;
	public pedido()
	{
		this.Productos = new ArrayList<producto>();
	}
	
	public void agregarProducto(producto Producto)
	{
		Productos.add(Producto);
	}
	public void eliminarProducto(producto Producto)
	{
		Productos.remove(Producto);
	}
	public double costoTotalPedido()
	{
		double total = 0 ;
		double size = Productos.size();
		for(int i = 0; i <= size-1; i++)
		{
			double precio = Productos.get(i).getPrecio() ;
			total= total +precio ;
		}
		return total;
	}
	public ArrayList<producto> getProductos()
	{
		return Productos;
	}
}
