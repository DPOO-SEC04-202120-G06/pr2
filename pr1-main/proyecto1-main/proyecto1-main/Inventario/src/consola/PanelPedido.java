package consola;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modelo.*;

@SuppressWarnings("serial")
public class PanelPedido extends JPanel implements ActionListener
{
	private JPanel PanelTitulo;
	private JPanel PanelProductos;
	private JPanel PanelBotones;
    private JTextField txtCedula;
	private Supermercado ventana;
	private POS pos;
	private pedido Pedido;
	private JButton botonAceptar;
	private JButton bAgregar;
	private JButton bBack;
	private DialogoProducto dPedido;
	private DialogoAsignacion dAsignacion;
	public final static String ACEPTAR = "ACEPTAR";
    public final static String AGREGAR = "AGREGAR_PRODUCTO";
    public final static String BACK = "REGRESAR";
    
    public PanelPedido(Supermercado pVentana, POS Pos)
    {
    	ventana = pVentana;
    	pos = Pos;
    	setLayout( new BorderLayout( ) );
    	Pedido = new pedido();
        PanelTitulo = new JPanel();
        PanelTitulo.setLayout(new GridLayout(2,1,2,2));
        PanelTitulo.setPreferredSize( new Dimension( 570, 100 ) );
        PanelTitulo.add(new JLabel("Pedido"));
        JPanel panelCedula = new JPanel( );
        panelCedula.setLayout( new FlowLayout( FlowLayout.CENTER, 5, 0 ) );
        JLabel etiquetaCedula = new JLabel( "Cédula " );
        txtCedula = new JTextField( );
        txtCedula.setColumns( 15 );
        panelCedula.add( etiquetaCedula );
        panelCedula.add( txtCedula );
        PanelTitulo.add( panelCedula );
        add( PanelTitulo, BorderLayout.NORTH);
        
        inicializarPanelPedido( );
        add( PanelProductos, BorderLayout.CENTER);
        
        inicializarPanelBotones( );
        add( PanelBotones, BorderLayout.SOUTH);
        
    }
    
    public void inicializarPanelPedido( )
    {
    	PanelProductos = new JPanel( );
    	PanelProductos.setLayout( new GridLayout() );
    	PanelProductos.setPreferredSize( new Dimension(540, 470 ) );
    	PanelProductos.setBorder( BorderFactory.createEtchedBorder() );
    	JPanel panelNombre = new JPanel( );
        panelNombre.setLayout( new FlowLayout( FlowLayout.LEFT, 25, 0 ) );
        panelNombre.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        panelNombre.setPreferredSize(new Dimension(560,30));;
        JLabel etiquetaNombre = new JLabel( "Nombre                                                                                                    " );
        panelNombre.add( etiquetaNombre );
        JLabel etiquetaPrecio = new JLabel( "Precio " );
        panelNombre.add(etiquetaPrecio);
        PanelProductos.add( panelNombre );
    }
    
    public void inicializarPanelBotones( )
    {
    	 PanelBotones = new JPanel( );
    	 PanelBotones.setLayout( new GridLayout( 1, 3, 8, 1 ) );
    	 PanelBotones.setSize(570,100);

         // Aceptar
         botonAceptar = new JButton( );
         botonAceptar.setText( "Aceptar" );
         botonAceptar.setActionCommand( ACEPTAR );
         botonAceptar.addActionListener( this );
         botonAceptar.setPreferredSize( new Dimension(40, 50 ) );
         PanelBotones.add( botonAceptar );

         // Cancelar
         bAgregar = new JButton( );
         bAgregar.setText( "Agregar Producto" );
         bAgregar.setActionCommand( AGREGAR );
         bAgregar.addActionListener( this );
         PanelBotones.add( bAgregar );
         
         bBack = new JButton( "Regresar al inicio" );
         bBack.setActionCommand( BACK );
         bBack.addActionListener( this );
         PanelBotones.add( bBack );
     }
    public void agregarProducto( )
    {
    	dPedido = new DialogoProducto( ventana, pos,Pedido );
    	dPedido.setVisible( true );
    	validate();
    	JPanel PanelProducto = new JPanel();
    	
    }

    @Override
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );

        if( comando.equals( ACEPTAR ) )
        {
            boolean registrado = pos.verificarCliente(txtCedula.getText());
            if ( registrado)
            {
            	pos.Comprar(Pedido);
            }
            else
            {
            	dAsignacion = new DialogoAsignacion( ventana, pos );
                dAsignacion.setVisible( true );
            	validate();
            	pos.Comprar(Pedido);
            	pos.calcularPuntos(Pedido, pos.getCliente(txtCedula.getText()));
            }
        }
        else if( comando.equals( AGREGAR ) )
        {
            agregarProducto( );
        }
        else if( comando.equals( BACK ) )
        {
            ventana.regresar( );
        }
	}
    }


