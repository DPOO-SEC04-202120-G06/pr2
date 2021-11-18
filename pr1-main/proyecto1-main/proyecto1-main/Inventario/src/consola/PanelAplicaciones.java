package consola;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;


@SuppressWarnings("serial")
public class PanelAplicaciones extends JPanel implements ActionListener
{
	public final static String POS = "POS";
    public final static String Inventario = "Encargado de Inventario";
    
    private JButton bPOS;
    private JButton bInventario;
    
    private Supermercado ventana;
    
    public PanelAplicaciones( Supermercado pVentana)
    {
    	ventana = pVentana;
    	setLayout( new GridLayout( 2, 3, 8, 2 ) );
        setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
        
        bPOS = new JButton( "POS" );
        bPOS.setActionCommand( POS );
        bPOS.addActionListener( this );
        bPOS.setPreferredSize( new Dimension( 40, 10 ) );
        add( bPOS );
        
        bInventario = new JButton( "Encargado de Inventario" );
        bInventario.setActionCommand( Inventario );
        bInventario.addActionListener( this );
        bInventario.setPreferredSize( new Dimension( 40, 10 ) );
        add( bInventario );
    }
    
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );

        if( comando.equals( POS ) )
        {
            ventana.iniciarPOS( );
        }
        else if( comando.equals( Inventario ) )
        {
            ventana.iniciarInventario( );
        }
    }
}
