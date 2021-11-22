package consola;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.*;

@SuppressWarnings("serial")
public class PanelEliminar extends JPanel implements ActionListener
{
	private JPanel PanelTitulo;
	private JPanel PanelProductos;
	private JPanel PanelBotones;
	private Supermercado ventana;
	private POS pos;
	private JButton bEliminar;
	private JButton bBack;
	public final static String ACEPTAR = "ACEPTAR";
    public final static String ELIMINAR = "ELIMINAR_LOTE";
    
    public PanelEliminar(Supermercado pVentana, POS Pos)
    {
    	ventana = pVentana;
    	pos = Pos;
    	setLayout( new BorderLayout( ) );
        PanelTitulo = new JPanel();
        PanelTitulo.setLayout(new GridLayout(2,1,2,2));
        PanelTitulo.setPreferredSize( new Dimension( 570, 100 ) );
        PanelTitulo.add(new JLabel("Eliminar Lotes"));
        PanelProductos = new JPanel( );
    	PanelProductos.setLayout( new GridLayout() );
    	PanelProductos.setPreferredSize( new Dimension(540, 470 ) );
    	PanelProductos.setBorder( BorderFactory.createEtchedBorder() );
    	JPanel panelNombre = new JPanel( );
        panelNombre.setLayout( new FlowLayout( FlowLayout.LEFT, 25, 0 ) );
        panelNombre.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        panelNombre.setPreferredSize(new Dimension(560,30));;
        JLabel etiquetaNombre = new JLabel( "Nombre/#lote                                                                                              " );
        panelNombre.add( etiquetaNombre );
        JLabel etiquetaPrecio = new JLabel( "Fecha de vencimiento " );
        panelNombre.add(etiquetaPrecio);
        PanelProductos.add( panelNombre );
        add( PanelTitulo, BorderLayout.NORTH);
        
        mostrarPos( );
        add( PanelProductos, BorderLayout.CENTER);
        
        inicializarPanelBotones( );
        add( PanelBotones, BorderLayout.SOUTH);
        
    }
    
    public void mostrarPos()
    {
    	HashMap<String, lote> Inventario = pos.getInventario().getinventario();
    	ArrayList<producto> productos = pos.getProductos();
    	int size = productos.size();
    	for(int i = 0; i <= size-1; i++)
		{
    		producto Producto = productos.get(i);
    		String nombre = Producto.getNombre();
    		lote Lote = Inventario.get(nombre);
    		nombre = nombre + Lote.getid();
    		JPanel PanelProducto = new JPanel();
        	PanelProducto.setLayout( new FlowLayout( FlowLayout.RIGHT, 5, 0 ) );
            JLabel etiquetaNombre = new JLabel(nombre +(" ".repeat(100-nombre.length())));
            JLabel etiquetaFecha = new JLabel();
            PanelProducto.add( etiquetaNombre );
            PanelProducto.add( etiquetaFecha );
            PanelProductos.add( PanelProducto );
		}
    }
    
    public void inicializarPanelBotones( )
    {
    	 PanelBotones = new JPanel( );
    	 PanelBotones.setLayout( new GridLayout( 1, 3, 8, 1 ) );
    	 PanelBotones.setSize(570,100);

         // Aceptar
    	 bEliminar = new JButton( );
         bEliminar.setText( "Eliminar lote" );
         bEliminar.setActionCommand( ELIMINAR );
         bEliminar.addActionListener( this );
         bEliminar.setPreferredSize( new Dimension(40, 50 ) );
         PanelBotones.add( bEliminar );

         
         bBack = new JButton( "Regresar al inicio" );
         bBack.setActionCommand( ACEPTAR );
         bBack.addActionListener( this );
         PanelBotones.add( bBack );
     }
    
	public void actionPerformed( ActionEvent pEvento )
	{
		String comando = pEvento.getActionCommand( );

		if( comando.equals( ELIMINAR ) )
		{
			ventana.iniciarPOS( );
		}
		else if( comando.equals( ACEPTAR ) )
		{
			ventana.iniciarInventario( );
		}
	}
    

}
