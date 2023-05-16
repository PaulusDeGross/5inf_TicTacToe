
public class SPIEL{

    private FENSTER fenster;
    private MAUSLISTENER mauslistener;
    private SYMBOLE spieler;
    private FELDLISTE feldliste;
    private ANZEIGE anzeige;
    
    public SPIEL()
    {
    }

    public void SpielStarten()
    {
        mauslistener = new MAUSLISTENER();
        spieler = SYMBOLE.O;
        feldliste = new FELDLISTE();
        fenster = new FENSTER(mauslistener);
        anzeige = new ANZEIGE(fenster.LeinwandGeben());
    }

    public void Klick(int x, int y)
    {
        int feld = feldliste.Suchen(x, y);
        System.out.println("Feld: " + feld + "| Spieler: " + spieler);
        SpielerWechseln();
    }

    private void SpielerWechseln()
    {
        if (spieler == SYMBOLE.O)
        {
            spieler = SYMBOLE.X;
        } else {
            spieler = SYMBOLE.O;
        }
    }

    private void FeldSetzen(int feld_x, int feld_y)
    {
    }

    private void SpielEvaluieren()
    {
        
    }
    
    public ANZEIGE AnzeigeGeben()
    {
        return anzeige;
    }
    
}
