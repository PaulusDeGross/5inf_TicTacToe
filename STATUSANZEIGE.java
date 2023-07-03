
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class STATUSANZEIGE extends ANZEIGE
{
    // Attribute

    // Konstruktor
    public STATUSANZEIGE (Graphics leinwand)
    {
        super(leinwand);
    }

    // Methoden
     @Override
    public void Zeichnen(int x, int y, int b, int h)
    {
        //nichts tun
        //später mal noch neue Klasse spielfeldAnzeige machen und da Zeichnen reintun
    }
    
    // Methoden
    public void Anzeigen( int x, int y, String text, int fontgroesse )
    {
        leinwand.setColor( Color.BLACK );
        leinwand.setFont( new Font( "Impact", Font.PLAIN, fontgroesse ) );
        leinwand.drawString(text, x, y );
    }

    public void Loeschen(int b, int h)
    {
        leinwand.setColor( Color.WHITE );
        leinwand.fillRect( 0, 0, b, h);
    }
}