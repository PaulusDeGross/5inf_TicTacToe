public class FELD {
    // Attribute
    private int x;
    private int y;
    private ANZEIGE anzeige;

    // Konstruktor
    public FELD ( int x_neu, int y_neu, ANZEIGE anzeige_neu )
    {
        x = x_neu;
        y = y_neu;
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
        return x == x_vgl && y == y_vgl;
    }
}
