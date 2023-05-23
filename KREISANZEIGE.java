
import java.awt.Graphics;
import java.awt.Color;

public class KREISANZEIGE extends ANZEIGE
{
    // Attribute
    private String meinName;

    // Konstruktor
    public KREISANZEIGE (Graphics leinwand)
    {
        super(leinwand);
    }

    // Methoden
     @Override
    public void Zeichnen(int x, int y, int b, int h)
    {
        leinwand.setColor( Color.BLACK );
        leinwand.drawOval( x, y, b, h);
    }
}