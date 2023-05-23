
import java.awt.Graphics;
import java.awt.Color;

public class FELDANZEIGE extends ANZEIGE
{
    // Attribute
    private String meinName;

    // Konstruktor
    public FELDANZEIGE (Graphics leinwand)
    {
        super(leinwand);
    }

    // Methoden
     @Override
    public void Zeichnen(int x, int y, int b, int h)
    {
        leinwand.setColor( Color.BLACK );
        leinwand.drawRect( x, y, b, h);
    }
}