public class FELDLISTE {

    private FELD[] felder;
    private int anzahl;

    // Konstruktor
    public FELDLISTE ()
    {
        felder = new FELD[KONST.spielfeldgroesse * KONST.spielfeldgroesse];
        Initialisieren();
    }

    // Methoden
    public void Initialisieren()
    {
        int i = 0;
        int j = 0;
        
        while(j < KONST.spielfeldgroesse)
        {
            // schauen ob trefferkoordinaten bei x und y größer sind als eckpunkt und bei x und y kleiner als eckpunkt x + feldgroesse & y + feldgroesse
            while(i < KONST.spielfeldgroesse)
            {
                int nr = i + j * 3;
                felder[nr] = new FELD (KONST.eckpunkteFelder[i][j][0], KONST.eckpunkteFelder[i][j][1], KONST.spiel.AnzeigeGeben());
                felder[nr].Anzeigen();
                i++;
            }
            j++;
        }
    }

    public int Suchen( int x, int y )
    {
        int i = 0;
        while( i < KONST.spielfeldgroesse * KONST.spielfeldgroesse)
        {
            if( felder[ i ].IstGetroffen( x, y ) )
            {
                return i;
            }
            i = i + 1;
        }
        return -1;
    }

    public boolean IstGetroffen( int x, int y )
    {
        return Suchen( x, y ) > -1;
    }
}
