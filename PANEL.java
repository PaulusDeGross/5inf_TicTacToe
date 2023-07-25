
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;

public class PANEL extends JPanel
{
    // Attribute
    private Image puffer;
    
    // Konstruktor
    public PANEL ()
    {        
    }

    // Methoden
    public void PanelInit()
    {
        puffer = createImage( getWidth(), getHeight() );
    }
    
    public Graphics LeinwandGeben()
    {
        return puffer.getGraphics();
    }
    
    @Override
    public void paint(Graphics g)
    {
        if( puffer != null )
        {
            g.drawImage( puffer, 0, KONST.offset - 20, getWidth(), getHeight(), null );
        }
    }
}