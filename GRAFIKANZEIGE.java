


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.Color;

public abstract class GRAFIKANZEIGE extends ANZEIGE
{
    protected int offset = 2; //Muss vllt no in KONSt nei
    
    public GRAFIKANZEIGE(Graphics leinwand) 
    {
        super(leinwand);
    }
    
    protected BufferedImage BildGeben(String dateiname)
    {
        BufferedImage img = null;
        try 
        {
            return img = ImageIO.read(new File(dateiname));
        } catch (IOException e) 
        {
            System.out.println ("Grafikatei" + dateiname + " nicht gefunden!");
            return null;
        }     
    }
    
    protected abstract void Zeichnen(int x, int y, int b, int h);
}