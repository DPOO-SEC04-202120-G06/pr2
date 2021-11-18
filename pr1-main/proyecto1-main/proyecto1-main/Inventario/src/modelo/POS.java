package modelo;

import java.util.ArrayList;



public class POS {
	private inventario inventario;
	private ArrayList<cliente> clientes;

	public void calcularPuntos(pedido Pedido, cliente Cliente)
	{
		double puntos= (Pedido.costoTotalPedido())/1000;
		double puntosAnteriores = Cliente.getpuntos();
		Cliente.setpuntos(puntos+puntosAnteriores);
	}
	public void registarCliente(cliente Cliente)
	{
		clientes.add(Cliente);
	}
	public void Comprar(pedido Pedido)
	{
		ArrayList<producto> Productos = Pedido.getProductos();
		int size = Productos.size();
		for(int i = 0; i <= size-1; i++)
		{
			
			producto Producto = Productos.get(i) ;
			String nombre = Producto.getNombre();
			inventario.Comprarproducto(nombre);
			
			
		}
	}
	
}
