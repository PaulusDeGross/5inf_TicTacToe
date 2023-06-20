
import java.awt.Graphics;
import java.awt.Color;

public class FELDANZEIGE extends ANZEIGE
{
    // Attribute
    private String meinName;
    private int feldrahmenDicke = 3;

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
        //leinwand.drawRect( x, y, b, h);
        leinwand.fillRect( x, y, b, h);
        leinwand.setColor(Color.WHITE);
        leinwand.fillRect(x + feldrahmenDicke, y + feldrahmenDicke, b - feldrahmenDicke, h - feldrahmenDicke);
    }
}