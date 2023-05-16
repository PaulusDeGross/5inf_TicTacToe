
import java.awt.Graphics;
import java.awt.Color;

public class ANZEIGE 
{
     protected Graphics leinwand;

    // Konstruktor
    public ANZEIGE ( Graphics leinwand )
    {
        this.leinwand = leinwand;
    }
    
    // Methoden
    private int XInPixel( int x )
    {
        return 15 + 25 * x;
    }

    private int YInPixel( int y )
    {
        return 65 + 25 * y;
    }

    public void Anzeigen( int x, int y )
    {
        Zeichnen( XInPixel( x ), YInPixel( y ), 25, 25 );
    }

    public void Loeschen( int x, int y )
    {
        leinwand.setColor( Color.WHITE );
        leinwand.fillRect( XInPixel( x ), YInPixel( y ), 25, 25 );
    }

    private void Zeichnen( int x, int y, int b, int h )
    {
        //FelderZeichnen
    }
}
