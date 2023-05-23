
public class SPIEL{

    private FENSTER fenster;
    private MAUSLISTENER mauslistener;
    private SYMBOLE spieler;
    private FELDLISTE feldliste;
    private FELDANZEIGE feldanzeige;
    private KREISANZEIGE kreisanzeige;
    private KREUZANZEIGE kreuzanzeige;
    
    public SPIEL()
    {
    }

    public void SpielStarten()
    {
        mauslistener = new MAUSLISTENER();
        spieler = SYMBOLE.O;
        fenster = new FENSTER(mauslistener);
        feldanzeige = new FELDANZEIGE(fenster.LeinwandGeben());
        kreisanzeige = new KREISANZEIGE(fenster.LeinwandGeben());
        kreuzanzeige = new KREUZANZEIGE(fenster.LeinwandGeben());
        feldliste = new FELDLISTE();
        fenster.repaint();
    }

    public void Klick(int x, int y)
    {
        int feld = feldliste.Suchen(x, y);
        System.out.println("Feld: " + feld + "| Spieler: " + spieler);
        FeldSetzen(feld);
        SpielerWechseln();
        fenster.repaint();
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

    private void FeldSetzen(int nr)
    {
        if(feldliste.SymbolGeben(nr) == SYMBOLE.LEER && spieler == SYMBOLE.X)
        {
            feldliste.XSetzen(nr);
        }
        else if(feldliste.SymbolGeben(nr) == SYMBOLE.LEER && spieler == SYMBOLE.X)
        {
             feldliste.OSetzen(nr);
        }
        else
        {
            System.out.println("Feld ist besetzt");
        }
    }

    private void SpielEvaluieren()
    {
        
    }
    
    public FELDANZEIGE FeldanzeigeGeben()
    {
        return feldanzeige;
    }
    
}
