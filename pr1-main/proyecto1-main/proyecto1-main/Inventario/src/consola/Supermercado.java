package consola;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.*;

import javax.swing.*;

import modelo.*;

import procesamiento.loader;


@SuppressWarnings("serial")
public class Supermercado extends JFrame
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------



    private JPanel panelAplicaciones;

  
    public Supermercado( )
    {
    setTitle( "Supermercado" );
    setSize( 580, 700 );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );


	ArrayList<producto> productos = ejecutarCargarProductos("./data/productos.txt");  // el parametro es la ruta del archivo productos.txt dentro del proyecto Eclipse
	for (producto prod : productos)
		System.out.println(prod);
	

	ArrayList<lote> lotes = ejecutarCargarLotes("./data/lotes.txt");  // parametros: ruta del archivo lotes.txt 
		System.out.println(lotes);
		

    // Configura la interfaz
    setLayout( new BorderLayout( ) );



    // Panel de botones
    panelAplicaciones = new PanelAplicaciones( this );
    add( panelAplicaciones, BorderLayout.CENTER );

    setResizable( false );
    setLocationRelativeTo( null );
    
    // Configurar ventana para llamar al metodo dispose() al cerrar la ventana
    setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
}

public void iniciarPOS()
{
	remove( panelAplicaciones );
	
	panelAplicaciones = new PanelPOS( this );
	add( panelAplicaciones, BorderLayout.CENTER );
}

public void iniciarInventario()
{
	remove( panelAplicaciones );
	
	panelAplicaciones = new PanelInventario( this );
	add( panelAplicaciones, BorderLayout.CENTER );
}

public void registrarCliente( )
{
	
}

public void nuevoPedido( )
{
	remove( panelAplicaciones );
	
	panelAplicaciones = new PanelAplicaciones( this );
	add( panelAplicaciones, BorderLayout.CENTER );
}

public void eliminarLotes()
{
	
}

public void agregarLotes()
{
	
}

public void revisarProducto()
{
	
}
public void regresar( )
{
	remove( panelAplicaciones );
	
	panelAplicaciones = new PanelPOS( this );
	add( panelAplicaciones, BorderLayout.CENTER );
}
	 
	private ArrayList<producto> ejecutarCargarProductos(String rutaArchivo)
	{
		ArrayList<producto> productos = new ArrayList<producto>();
		try
		{
			productos = loader.leerInfoArchivoProducto(rutaArchivo);
			System.out.println("OK Se cargó el archivo " + rutaArchivo + " con información de los productos.");
		}
		catch (FileNotFoundException e)
		{
			System.out.println("ERROR: el archivo " + rutaArchivo + " no se encontró.");
			System.out.println(e.getMessage());
		}
		catch (IOException e)
		{
			System.out.println("ERROR: hubo un problema leyendo el archivo " + rutaArchivo);
			System.out.println(e.getMessage());
		}

		return productos;
	}
	
	private ArrayList<lote> ejecutarCargarLotes(String rutaArchivo)
	{
		ArrayList<lote> lotes = new ArrayList<lote>();
		try
		{
			lotes = loader.leerInfoArchivoLotes(rutaArchivo);
			System.out.println("OK Se cargó el archivo " + rutaArchivo + " con información de los productos.");
		}
		catch (FileNotFoundException e)
		{
			System.out.println("ERROR: el archivo " + rutaArchivo + " no se encontró.");
			System.out.println(e.getMessage());
		}
		catch (IOException e)
		{
			System.out.println("ERROR: hubo un problema leyendo el archivo " + rutaArchivo);
			System.out.println(e.getMessage());
		}

		return lotes;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
			try
	        {
	            // Unifica la interfaz para Mac y para Windows.
	            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );

	            Supermercado interfaz = new Supermercado( );
	            interfaz.setVisible( true );
	        }
	        catch( Exception e )
	        {
	            e.printStackTrace( );
	        }
	}
}