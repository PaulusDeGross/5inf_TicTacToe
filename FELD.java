public class FELD {
    // Attribute
    private int x;
    private int y;
    private SYMBOLE symbol;
    private FELDANZEIGE anzeige;

    // Konstruktor
    public FELD ( int x_neu, int y_neu, FELDANZEIGE anzeige_neu )
    {
        symbol = SYMBOLE.LEER;
        x = x_neu;
        y = y_neu;
        if( anzeige_neu == null )
        {
            System.out.println( "Fehler" );
        }
        anzeige = anzeige_neu;
    }

    // Methoden
    public void Anzeigen()
    {
        anzeige.Anzeigen( x, y );
    }
    
    public void Entfernen()
    {
        anzeige.Loeschen( x, y );
    }

    public boolean IstGetroffen( int x_vgl, int y_vgl )
    {
        return x < x_vgl && y < y_vgl && x + KONST.feldgroesse > x_vgl && y + KONST.feldgroesse > y_vgl;
    }
    
    public int XGeben()
    {
        return x;
    }
    
    public int YGeben()
    {
        return y;
    }
    
    public SYMBOLE SymbolGeben()
    {
        return symbol;
    }
    
    public void XSetzen()
    {
        symbol = SYMBOLE.X;
    }
    
    public void OSetzen()
    {
        symbol = SYMBOLE.O;
    }
}
