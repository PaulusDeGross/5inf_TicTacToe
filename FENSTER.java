import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JPanel;
import java.awt.Dimension;


public class FENSTER extends JFrame implements WindowListener
{
    // Attribute
    private Image puffer;
    private Image icon;
    private JPanel spielfeldPanel;

    // Konstruktor
    public FENSTER (MAUSLISTENER maus)
    {
        Initialisieren(maus);
    }

    // Methoden
    private void Initialisieren(MAUSLISTENER maus)
    {
        setSize( KONST.fensterbreite, KONST.fensterhoehe );
        setResizable( KONST.groesseveraenderbar );
        setTitle( KONST.titel );
        icon = BildGeben("Icon2.png");//noch n bisschen hässlich ig
        setIconImage(icon);
        spielfeldPanel = new javax.swing.JPanel();
        add(spielfeldPanel);
        puffer = createImage( getWidth(), getHeight() );
        
        spielfeldPanel.setBackground(Color.WHITE);
        setContentPane(spielfeldPanel);
        setPreferredSize(new Dimension(KONST.fensterbreite, KONST.fensterbreite));
        
        setVisible( KONST.sichtbar );
        addMouseListener(maus);
    }
    
    public Graphics LeinwandGeben()
    {
        //return puffer.getGraphics();
        return spielfeldPanel.getGraphics();
    }
    
    private BufferedImage BildGeben(String dateiname)
    {
        BufferedImage img = null;
        try 
        {
            System.out.println(dateiname);
            return img = ImageIO.read(new File(dateiname));
        } catch (IOException e) 
        {
            System.out.println ("Grafikdatei" + dateiname + " nicht gefunden!");
            return null;
        }     
    }

    public void PufferLoeschen()
    {
        Graphics g = LeinwandGeben();
        g.setColor( KONST.hintergrundfarbe );
        g.fillRect( 0, 0, getWidth(), getHeight() );
    }

    @Override
    public void paint( Graphics g )
    {
        if( puffer != null )
        {
            g.drawImage( puffer, 0, 0, getWidth(), getHeight(), null );
        }
    }
    ///*
    public void eckpunkteTesten()
    {
        int _y = 0;
        while(_y < KONST.spielfeldgroesse)
        {
            int _x = 0;
            while(_x < KONST.spielfeldgroesse)
            {
              System.out.println(KONST.eckpunkteFelder[_x][_y][0] + " " + KONST.eckpunkteFelder[_x][_y][1]);
              _x++;  
            }
            _y++;
        }
    }
    //*/
    // WindowListener
    @Override
    public void windowDeactivated( WindowEvent event )
    {
        //nichts tun
    }

    @Override
    public void windowActivated( WindowEvent event )
    {
        //nichts tun
    }

    @Override
    public void windowDeiconified( WindowEvent event )
    {
       //nichts tun
    }

    @Override
    public void windowIconified( WindowEvent event )
    {
        //nichts tun
    }

    @Override
    public void windowClosed( WindowEvent event )
    {
        // Nichts tun
    }

    @Override
    public void windowClosing( WindowEvent event )
    {
        System.exit(0);
    }

    @Override
    public void windowOpened( WindowEvent event )
    {
        // Nichts tun
    }
}