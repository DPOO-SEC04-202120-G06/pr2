package consola;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


@SuppressWarnings("serial")
public class PanelPOS extends JPanel implements ActionListener 
{
	public final static String REGISTRAR = "REGISTRAR_CLIENTE";

    /**
     * Opci�n anular.
     */
    public final static String NUEVO = "NUEVO_PEDIDO";

    /**
     * Opci�n buscar.
     */
    public final static String BACK = "REGRESAR";
    
    private JButton bRegistro;

    /**
     * Bot�n Anular.
     */
    private JButton bNuevo;

    /**
     * Bot�n de b�squeda.
     */
    private JButton bBack;
    
    private Supermercado ventana;
    
    public PanelPOS( Supermercado pVentana)
    {
        // Guarda la referencia a la ventana padre
        ventana = pVentana;

        // Configura propiedades visuales
        setLayout( new GridLayout( 2, 4, 8, 2 ) );
        setBorder( new EmptyBorder( 5, 5, 5, 5 ) );

        // Bot�n registrar
       	bRegistro = new JButton( "Registrar Cliente" );
        bRegistro.setActionCommand( REGISTRAR );
        bRegistro.addActionListener( this );
        bRegistro.setPreferredSize( new Dimension( 40, 10 ) );
        add( bRegistro );

        // Bot�n anular registro
        bNuevo = new JButton( "Nuevo Pedido" );
        bNuevo.setActionCommand( NUEVO );
        bNuevo.addActionListener( this );
        add( bNuevo );

        // Bot�n buscar pasajero
        bBack = new JButton( "Regresar al inicio" );
        bBack.setActionCommand( BACK );
        bBack.addActionListener( this );
        add( bBack );
        
    }
	@Override
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );

        if( comando.equals( REGISTRAR ) )
        {
            ventana.registrarCliente( );
        }
        else if( comando.equals( NUEVO ) )
        {
            ventana.nuevoPedido( );
        }
        else if( comando.equals( BACK ) )
        {
            ventana.regresar( );
        }
	}
}
