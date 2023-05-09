import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class MAUSLISTENER implements MouseListener{
    
    private int[] Punkt;
    
    public MAUSLISTENER()
    {
        Punkt = new int[2];
    }

    @Override
    public void mouseClicked(MouseEvent klick)
    {
        int maus_x = klick.getX();
        int maus_y = klick.getY();
        
        PunktSetzen(maus_x, maus_y);
        
        System.out.println("Maus X: " + maus_x + " | Maus Y: " + maus_y);
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
    
    private void PunktSetzen(int x, int y)
    {
        Punkt[0] = x;
        Punkt[1] = y;
    }
    
    public int[] PunktGeben()
    {
        return Punkt;
    }
    
}
