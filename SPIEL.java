

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
            kreuzanzeige.Zeichnen(feldliste.XGeben(nr), feldliste.YGeben(nr), KONST.feldgroesse, KONST.feldgroesse);
            fenster.repaint();
            SpielerWechseln();
        }
        else if(feldliste.SymbolGeben(nr) == SYMBOLE.LEER && spieler == SYMBOLE.O)
        {
            feldliste.OSetzen(nr);
            kreisanzeige.Zeichnen(feldliste.XGeben(nr), feldliste.YGeben(nr), KONST.feldgroesse, KONST.feldgroesse);
            fenster.repaint();
            SpielerWechseln();
        }
        else
        {
            System.out.println("Feld ist besetzt");
        }
        SpielEvaluieren();
    }

    private SYMBOLE SpielEvaluieren()
    {
        for(SYMBOLE symbol : SYMBOLE.values())
        {
            if(symbol == SYMBOLE.LEER)
            {
                continue;
            }
            if(
                feldliste.SymbolGeben(0) == symbol && feldliste.SymbolGeben(1) == symbol && feldliste.SymbolGeben(2) == symbol ||
                feldliste.SymbolGeben(3) == symbol && feldliste.SymbolGeben(4) == symbol && feldliste.SymbolGeben(5) == symbol ||
                feldliste.SymbolGeben(6) == symbol && feldliste.SymbolGeben(7) == symbol && feldliste.SymbolGeben(8) == symbol ||
                
                feldliste.SymbolGeben(0) == symbol && feldliste.SymbolGeben(3) == symbol && feldliste.SymbolGeben(6) == symbol ||
                feldliste.SymbolGeben(1) == symbol && feldliste.SymbolGeben(4) == symbol && feldliste.SymbolGeben(7) == symbol ||
                feldliste.SymbolGeben(2) == symbol && feldliste.SymbolGeben(5) == symbol && feldliste.SymbolGeben(8) == symbol ||
                
                feldliste.SymbolGeben(0) == symbol && feldliste.SymbolGeben(4) == symbol && feldliste.SymbolGeben(8) == symbol ||
                feldliste.SymbolGeben(2) == symbol && feldliste.SymbolGeben(4) == symbol && feldliste.SymbolGeben(6) == symbol
            )
            {
                System.out.println(symbol + " hat gewonnen.");
            }
            return symbol;
        }
        return null;
    }
    
    public FELDANZEIGE FeldanzeigeGeben()
    {
        return feldanzeige;
    }
    
}

