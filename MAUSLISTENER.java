import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class MAUSLISTENER implements MouseListener{
    
    private int[] geklicktesFeld;
    
    public MAUSLISTENER()
    {
        geklicktesFeld = new int[2];
    }

    @Override
    public void mouseClicked(MouseEvent klick)
    {
        int maus_x = klick.getX();
        int maus_y = klick.getY();
        
        System.out.println("Maus X: " + maus_x + " | Maus Y: " + maus_y);
        
        int _y = 0;
        while(_y < KONST.spielfeldgroesse)
        {
            int _x = 0;
            while(_x < KONST.spielfeldgroesse){
                int feld_x = KONST.eckpunkteFelder[_x][_y][0];
                int feld_y = KONST.eckpunkteFelder[_x][_y][1];
                
                if(maus_x < feld_x && maus_x > feld_x + KONST.feldgroesse && maus_y < feld_y && feld_y > feld_y + KONST.feldgroesse)
                {
                    geklicktesFeldSetzen(_x, _y);
                }
            }
        }
        
        
    }

    @Override
    public void mouseEntered(MouseEvent eintreten)
    {
    }

    @Override
    public void mouseExited(MouseEvent verlassen)
    {
    }
    
    @Override
    public void mousePressed(MouseEvent druecken)
    {
    }
    
    @Override
    public void mouseReleased(MouseEvent loslassen)
    {
    }
    
    private void geklicktesFeldSetzen(int x, int y)
    {
        geklicktesFeld[0] = x;
        geklicktesFeld[1] = y;
    }
    
    public int[] geklicktesFeldGeben()
    {
        return geklicktesFeld;
    }
    
}
