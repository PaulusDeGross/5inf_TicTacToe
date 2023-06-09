
import java.awt.Color;

public class KONST {

    public KONST() {
        System.out.println("KONST");
        
    }

    public static final String titel = "TIC TAC TOE";
    public static final int actionbar_offset = 28;
    public static final int feld_y_offset = 0;
    public static final int feld_x_offset = 0;
    public static final int offset = 100 + actionbar_offset;
    public static final int fensterbreite = 600;
    public static final int fensterhoehe = fensterbreite + offset;
    public static final boolean groesseveraenderbar = true;
    public static final boolean sichtbar = true;
    public static final Color hintergrundfarbe = Color.WHITE;
    public static final int spielfeldgroesse = 5;
    public static final int startX = 1;
    public static final int startY = 1;
    public static final int feldgroesse = ((fensterhoehe - offset) / spielfeldgroesse);
    public static final int[][][]eckpunkteFelder = eckpunkteFelderGeben(startX, startY);
    public static final SPIEL spiel = new SPIEL();
    
    private static int[][][] eckpunkteFelderGeben(int x, int y)
    {
        int eckpunkteFelder[][][] = new int[spielfeldgroesse][spielfeldgroesse][2];
        int _y = 0;
        while(_y < spielfeldgroesse)
        {
            int _x = 0;
            while(_x < spielfeldgroesse)
            {
              eckpunkteFelder[_x][_y][0] = x + _x * feldgroesse + feld_x_offset;
              eckpunkteFelder[_x][_y][1] = y + _y * feldgroesse + offset + feld_y_offset;
              _x++;  
            }
            _y++;
        }
        return eckpunkteFelder;
    }
}