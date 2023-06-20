
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;

public class KREISANZEIGE extends GRAFIKANZEIGE
{
    // Attribute
    private String dateiname;
    private Image kreis;
    
    // Konstruktor
    public KREISANZEIGE (Graphics leinwand)
    {
        super(leinwand);
        dateiname = "Kreis.png";
        kreis = BildGeben(dateiname);
    }

    // Methoden
    @Override
    public void Zeichnen(int x, int y, int b, int h)
    {
        int orginalbildbreite = kreis.getWidth(null);
        int orginalbildhoehe = kreis.getHeight(null);
        leinwand.setColor(Color.BLACK);
        leinwand.drawImage( kreis, x + offset, y + offset, x + b - offset, y + h - offset, 0, 0, orginalbildbreite, orginalbildhoehe, null);
    }
}