package modelo;

import java.util.ArrayList;





public class POS {
	private inventario Inventario;
	private ArrayList<cliente> clientes;
	private ArrayList<producto> productos;
	
	public POS()
	{
		this.Inventario = new inventario();
		this.clientes = new ArrayList<cliente>();
		this.productos = new ArrayList<producto>();
	}

	public void calcularPuntos(pedido Pedido, cliente Cliente)
	{
		double puntos= (Pedido.costoTotalPedido())/1000;
		double puntosAnteriores = Cliente.getpuntos();
		cliente ClienteA = Cliente; 
		Cliente.setpuntos(puntos+puntosAnteriores);
		clientes.set(clientes.indexOf(ClienteA), Cliente);
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
			Inventario.Comprarproducto(nombre);
			
			
		}
	}
	
	public boolean verificarCliente(String cedulaa)
	{
		boolean encontrado = false;
		double size = clientes.size();
        for( int i = 0; i < size ; i++ )
        {
        
        cliente Cliente = clientes.get(i);
        String cedulab = Cliente.getcedula();
        if(cedulaa == cedulab)
        	{
        	encontrado = true;
        	}
        }

        return encontrado;
	}
	
	public cliente getCliente(String cedulaa)
	{
		double size = clientes.size();
        cliente ClienteR = null;
        for( int i = 0; i < size ; i++ )
        {
        cliente Cliente = clientes.get(i);
        String cedulab = Cliente.getcedula();
        if(cedulaa == cedulab)
        	{
        	ClienteR = Cliente;
        	}
        }

        return ClienteR;
	}
	public producto getProducto(String codigobarras)
	{
		producto Productof = null;
		double size = productos.size();
        for( int i = 0; i < size-1 ; i++ )
        {
        
        producto Producto = productos.get(i);
        String codigoBarras = Producto.getCodigoBarras();
        if(codigobarras == codigoBarras)
        	{
        	Productof = Producto;
        	}
        }
        return Productof;
	}
	
	public void agregarLotes(ArrayList<lote> lotes)
	{
		Inventario.agregarLotes(lotes);
	}
	
	public void agregarproductos(ArrayList<producto> Productos)
	{
		double size = Productos.size();
        for( int i = 0; i < size-1 ; i++ )
        {producto Producto = productos.get(i);
        productos.add(Producto);
        }
        }
	
}
