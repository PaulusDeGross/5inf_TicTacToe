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
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.*;
import javax.swing.KeyStroke;


public class FENSTER extends JFrame implements WindowListener
{
    // Attribute
    private Image icon;
    private PANEL spielfeldPanel;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem item3;
    private JMenuItem item4;
    private JMenuItem item5;
    private JMenuItem item6;
    private JMenuItem item7;
    private JMenuItem item8;
    private JMenuItem item9;
    private JMenuItem item10;
    private JMenuItem itemD;
    private JMenuItem itemE;

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
        spielfeldPanel = new PANEL();
        add(spielfeldPanel);
        
        MenuInit();

        spielfeldPanel.setBackground(Color.WHITE);
        setContentPane(spielfeldPanel);
        setPreferredSize(new Dimension(KONST.fensterbreite, KONST.fensterhoehe));

        setVisible( KONST.sichtbar );
        
        spielfeldPanel.PanelInit();
        
        addMouseListener(maus);
    }
    
    private void MenuInit()
    {
        menuBar = new JMenuBar();
        
        //Feldgroessenmenü
        FeldgroesseMenuInit();
        
        //Sprachmenü
        SprachMenuInit();
        
        setJMenuBar(menuBar);
    }

    public Graphics LeinwandGeben()
    {
        //return puffer.getGraphics();
        return spielfeldPanel.LeinwandGeben();
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
        /*Graphics g = LeinwandGeben();
        g.setColor( KONST.hintergrundfarbe );
        g.fillRect( 0, 0, getWidth(), getHeight() );*/
    }

    @Override
    public void paint( Graphics g )
    {
        super.paint(g);
                
        spielfeldPanel.paint(g);
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
    
    public void FeldgroesseMenuInit()
    {
        menu = new JMenu("Feldgroesse");
        menuBar.add(menu);
        
        item3 = new JMenuItem("3x3",KeyEvent.VK_T);
        item3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.ALT_MASK));
        item3.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
        menu.add(item3);
        
        item4 = new JMenuItem("4x4",KeyEvent.VK_T);
        item4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, ActionEvent.ALT_MASK));
        item4.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
        menu.add(item4);
        
        item5 = new JMenuItem("5x5",KeyEvent.VK_T);
        item5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_5, ActionEvent.ALT_MASK));
        item5.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
        menu.add(item5);
        
        item6 = new JMenuItem("6x6",KeyEvent.VK_T);
        item6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_6, ActionEvent.ALT_MASK));
        item6.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
        menu.add(item6);
        
        item7 = new JMenuItem("7x7",KeyEvent.VK_T);
        item7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_7, ActionEvent.ALT_MASK));
        item7.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
        menu.add(item7);
        
        item8 = new JMenuItem("8x8",KeyEvent.VK_T);
        item8.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_8, ActionEvent.ALT_MASK));
        item8.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
        menu.add(item8);
        
        item9 = new JMenuItem("9x9",KeyEvent.VK_T);
        item9.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_9, ActionEvent.ALT_MASK));
        item9.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
        menu.add(item9);
        
        item10 = new JMenuItem("10x10",KeyEvent.VK_T);
        item10.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_0, ActionEvent.ALT_MASK));
        item10.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
        menu.add(item10);
    }
    
    public void SprachMenuInit()
    {
        menu = new JMenu("Sprache");
        menuBar.add(menu);
        
        itemD = new JMenuItem("Deutsch",KeyEvent.VK_T);
        itemD.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
        itemD.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
        menu.add(itemD);
        
        itemE = new JMenuItem("English",KeyEvent.VK_T);
        itemE.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
        itemE.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
        menu.add(itemE);
    }
    
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