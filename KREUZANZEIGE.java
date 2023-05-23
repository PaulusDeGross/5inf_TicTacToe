
import java.awt.Graphics;
import java.awt.Color;

public class KREUZANZEIGE extends ANZEIGE
{
    // Attribute
    private String meinName;

    // Konstruktor
    public KREUZANZEIGE (Graphics leinwand)
    {
        super(leinwand);
    }

    // Methoden
    @Override
    public void Zeichnen(int x, int y, int b, int h)
    {
        leinwand.setColor( Color.BLACK );
        leinwand.drawLine( x, y, x + b, y - h);
        leinwand.drawLine( x + b, y, b, y - h);
    }
}