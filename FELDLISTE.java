public class FELDLISTE {

    private FELD[] felder;

    // Konstruktor
    public FELDLISTE ()
    {
        felder = new FELD[KONST.spielfeldgroesse * KONST.spielfeldgroesse];
        Initialisieren();
    }

    // Methoden
    public void Initialisieren()
    {
        int k = 0;        
        while(k < KONST.spielfeldgroesse)
        {
            int i = 0;
            // schauen ob trefferkoordinaten bei x und y größer sind als eckpunkt und bei x und y kleiner als eckpunkt x + feldgroesse & y + feldgroesse
            while(i < KONST.spielfeldgroesse)
            {
                int nr = i + k * KONST.spielfeldgroesse;
                felder[nr] = new FELD (KONST.eckpunkteFelder[i][k][0], KONST.eckpunkteFelder[i][k][1], KONST.spiel.FeldanzeigeGeben());
                System.out.println("Feld: " + nr + "\n" + "Koordinaten: " + KONST.eckpunkteFelder[i][k][0] + ", " + KONST.eckpunkteFelder[i][k][1]);
                felder[nr].Anzeigen();
                i++;
            }
            k++;
        }
    }

    public int Suchen( int x, int y )
    {
        int i = 0;
        while( i < KONST.spielfeldgroesse * KONST.spielfeldgroesse)
        {
            if( felder[ i ].IstGetroffen( x, y ) )
            {   
                System.out.println(i);
                return i;
            }
            i = i + 1;
        }
        System.out.println("Feld nicht gefunden");
        return -1;
    }
    
    public int XGeben (int _nr)
    {
        return felder[_nr].XGeben();
    }
    
    public int YGeben (int _nr)
    {
        return felder[_nr].YGeben();
    }
    
    public void Anzeigen(int _nr)
    {
        felder[_nr].Anzeigen();
    }
    
    public SYMBOLE SymbolGeben(int _nr)
    {   
        return felder[_nr].SymbolGeben();
    }
    
    public void XSetzen(int _nr)
    {
        felder[_nr].XSetzen();
    }
    
    public void OSetzen( int _nr)
    {
        felder[_nr].OSetzen();
    }
    
    public int LaengeGeben()
    {
        return felder.length;
    }
}
