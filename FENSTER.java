import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;

public class FENSTER extends JFrame
{
    // Attribute
    private Image puffer;

    // Konstruktor
    public FENSTER (MAUSLISTENER maus)
    {
        setSize( KONST.fensterbreite, KONST.fensterhoehe );
        setResizable( KONST.groesseveränderbar );
        setTitle( KONST.titel );
        setVisible( KONST.sichtbar );
        puffer = createImage( getWidth(), getHeight() );
        addMouseListener(maus);
    }

    // Methoden
    public Graphics LeinwandGeben()
    {
        return puffer.getGraphics();
    }

    public void PufferLoeschen()
    {
        Graphics g = LeinwandGeben();
        g.setColor( KONST.hintergrundfarbe );
        g.fillRect( 0, 0, getWidth(), getHeight() );
    }

    @Override
    public void paint( Graphics g )
    {
        if( puffer != null )
        {
            g.drawImage( puffer, 0, 0, getWidth(), getHeight(), null );
        }
    }
    ///*
    public void eckpunkteTesten()
    {
        int _y = 0;
        while(_y < KONST.spielfeldgroesse)
        {
            int _x = 0;
            while(_x < KONST.spielfeldgroesse)
            {
              System.out.println(KONST.eckpunkteFelder[_x][_y][0] + " " + KONST.eckpunkteFelder[_x][_y][1]);
              _x++;  
            }
            _y++;
        }
    }
    //*/
}