
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;

public class KREUZANZEIGE extends GRAFIKANZEIGE
{
    // Attribute
    private String dateiname;
    private Image kreuz;
    
    // Konstruktor
    public KREUZANZEIGE (Graphics leinwand)
    {
        super(leinwand);
        dateiname = "Kreuz.png";
        kreuz = BildGeben(dateiname);
    }

    // Methoden
    @Override
    public void Zeichnen(int x, int y, int b, int h)
    {
        int orginalbildbreite = kreuz.getWidth(null);
        int orginalbildhoehe = kreuz.getHeight(null);
        leinwand.setColor(Color.BLACK);
        leinwand.drawImage( kreuz, x + offset, y + offset, x + b - offset, y + h - offset, 0, 0, orginalbildbreite, orginalbildhoehe, null);
    }
}