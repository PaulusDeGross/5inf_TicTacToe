
import java.awt.Color;

public class KONST {

    public KONST() {
        System.out.println("KONST");
        
    }

    public static final String titel = "TIC TAC TOE";
    public static final int fensterbreite = 605;
    public static final int fensterhoehe = 605;
    public static final boolean groesseveränderbar = false;
    public static final boolean sichtbar = true;
    public static final Color hintergrundfarbe = Color.WHITE;
    public static final int spielfeldgroesse = 3;
    public static final int feldgroesse = 25;
    public static final int startX = 10;
    public static final int startY = 10;
    public static final int[][][]eckpunkteFelder = eckpunkteFelderGeben(startX, startY);
    
    private static int[][][] eckpunkteFelderGeben(int x, int y)
    {
        int eckpunkteFelder[][][] = new int[spielfeldgroesse][spielfeldgroesse][2];
        int _y = 0;
        while(_y < spielfeldgroesse)
        {
            int _x = 0;
            while(_x < spielfeldgroesse)
            {
              eckpunkteFelder[_x][_y][0] = x + _x * feldgroesse;
              eckpunkteFelder[_x][_y][1] = y + _y * feldgroesse;
              _x++;  
            }
            _y++;
        }
        return eckpunkteFelder;
    }
}
