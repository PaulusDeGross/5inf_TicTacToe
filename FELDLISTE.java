public class FELDLISTE {

    private FELD[] felder;
    private int anzahl;

    // Konstruktor
    public FELDLISTE ()
    {
        felder = new FELD[KONST.spielfeldgroesse * KONST.spielfeldgroesse];
        anzahl = 0;
    }

    // Methoden
    public FELD[] Initialisieren()
    {
        int i = 0;
        int j = 0;
        
        while(j < KONST.spielfeldgroesse)
        {
            // schauen ob trefferkoordinaten bei x und y größer sind als eckpunkt und bei x und y kleiner als eckpunkt x + feldgroesse & y + feldgroesse
            while(i < KONST.spielfeldgroesse)
            {
                felder[i] = new FELD (KONST.eckpunkteFelder[i][j][0], KONST.eckpunkteFelder[i][j][1], KONST.spiel.AnzeigeGeben());
                felder[i].Anzeigen();
                i++;
            }
            j++;
        }
        return felder;
    }

    public void Entfernen( int nr )
    {
        if( nr >= 0 && nr < anzahl )
        {
            felder[ nr ].Entfernen();
            anzahl = anzahl - 1;
            int i = nr;
            while( i < anzahl )
            {
                felder[ i ] = felder[ i + 1 ];
                i = i + 1;
            }
            felder[ anzahl ] = null;
        }
    }

    public int Suchen( int x, int y )
    {
        int i = 0;
        while( i < anzahl )
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

    public void LetztenEntfernen()
    {
        Entfernen( 0 );
    }

    public void Entfernen( int x, int y )
    {
        Entfernen( Suchen( x, y ) );
    }

    public int AnzahlGeben()
    {
        return anzahl;
    }

}
