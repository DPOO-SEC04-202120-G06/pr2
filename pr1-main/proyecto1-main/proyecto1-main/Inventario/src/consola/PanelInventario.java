package consola;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


@SuppressWarnings("serial")
public class PanelInventario extends JPanel implements ActionListener
{
	public final static String ELIMINAR = "ELIMINAR_LOTE";

    /**
     * Opci�n anular.
     */
    public final static String AGREGAR = "AGREGAR_LOTE";

    /**
     * Opci�n buscar.
     */
    public final static String REVISAR = "REVISAR";
    
    private JButton bEliminar;

    /**
     * Bot�n Anular.
     */
    private JButton bAgregar;

    /**
     * Bot�n de b�squeda.
     */
    private JButton bRevisar;
    
    private Supermercado ventana;
    
    public PanelInventario( Supermercado pVentana)
    {
        // Guarda la referencia a la ventana padre
        ventana = pVentana;

        // Configura propiedades visuales
        setLayout( new GridLayout( 2, 4, 8, 2 ) );
        setBorder( new EmptyBorder( 5, 5, 5, 5 ) );

        // Bot�n registrar
        bEliminar = new JButton( "Eliminar Lotes" );
        bEliminar.setActionCommand( ELIMINAR );
        bEliminar.addActionListener( this );
        bEliminar.setPreferredSize( new Dimension( 40, 10 ) );
        add( bEliminar );

        // Bot�n anular registro
        bAgregar = new JButton( "Agregar Lotes" );
        bAgregar.setActionCommand( AGREGAR );
        bAgregar.addActionListener( this );
        add( bAgregar );

        // Bot�n buscar pasajero
        bRevisar = new JButton( "Regresar al inicio" );
        bRevisar.setActionCommand( REVISAR );
        bRevisar.addActionListener( this );
        add( bRevisar );
        
    }
	@Override
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );

        if( comando.equals( ELIMINAR ) )
        {
            ventana.eliminarLotes( );
        }
        else if( comando.equals( AGREGAR ) )
        {
            ventana.agregarLotes( );
        }
        else if( comando.equals( REVISAR ) )
        {
            ventana.revisarProducto( );
        }
	}
}
