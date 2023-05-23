
import java.awt.Graphics;
import java.awt.Color;

public abstract class ANZEIGE 
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
        return KONST.feldgroesse * x;
    }

    private int YInPixel( int y )
    {
        return KONST.feldgroesse * y;
    }

    public void Anzeigen( int x, int y )
    {
        Zeichnen( x , y, KONST.feldgroesse, KONST.feldgroesse );
    }

    public void Loeschen( int x, int y )
    {
        leinwand.setColor( Color.WHITE );
        leinwand.fillRect( XInPixel( x ), YInPixel( y ), KONST.feldgroesse, KONST.feldgroesse );
    }

    protected abstract void Zeichnen( int x, int y, int b, int h);
}
