
import javax.swing.JOptionPane;

public class SPIEL{

    private FENSTER fenster;
    private MAUSLISTENER mauslistener;
    private SYMBOLE spieler;
    private FELDLISTE feldliste;
    private FELDANZEIGE feldanzeige;
    private KREISANZEIGE kreisanzeige;
    private KREUZANZEIGE kreuzanzeige;
    private int platziert_zaehler;
    
    public SPIEL()
    {
    }

    public void SpielStarten()
    {
        mauslistener = new MAUSLISTENER();
        fenster = new FENSTER(mauslistener);
        Initialisieren();
    }

    public void Initialisieren()
    {
        spieler = SYMBOLE.O;
        feldanzeige = new FELDANZEIGE(fenster.LeinwandGeben());
        kreisanzeige = new KREISANZEIGE(fenster.LeinwandGeben());
        kreuzanzeige = new KREUZANZEIGE(fenster.LeinwandGeben());
        feldliste = new FELDLISTE();
        platziert_zaehler = 0;
        fenster.repaint();
    }

    public void Klick(int x, int y)
    {
        int feld = feldliste.Suchen(x, y);
        System.out.println("Feld: " + feld + "| Spieler: " + spieler);
        if(feld >= 0)
        {
            FeldSetzen(feld);
        }
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
            platziert_zaehler++;
            fenster.repaint();
            SpielerWechseln();
        }
        else if(feldliste.SymbolGeben(nr) == SYMBOLE.LEER && spieler == SYMBOLE.O)
        {
            feldliste.OSetzen(nr);
            kreisanzeige.Zeichnen(feldliste.XGeben(nr), feldliste.YGeben(nr), KONST.feldgroesse, KONST.feldgroesse);
            platziert_zaehler++;
            fenster.repaint();
            SpielerWechseln();
        }
        else
        {
            System.out.println("Feld ist besetzt");
        }
        SYMBOLE gewinner = SpielEvaluieren();
        if(gewinner != null && platziert_zaehler < KONST.spielfeldgroesse * KONST.spielfeldgroesse || gewinner != null)
        {
            Gewinner(gewinner);
        }
        else if (gewinner == null && platziert_zaehler >= KONST.spielfeldgroesse * KONST.spielfeldgroesse)
        {
            Unentschieden();
        }
        System.out.println(platziert_zaehler);
    }

    private SYMBOLE SpielEvaluieren()
    {
        for(int i = 0; i <= 2; i++)
        {
            SYMBOLE symbol = SYMBOLE.values()[i];
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
                return symbol;
            }
        }
        return null;
    }
    
    private void Unentschieden()
    {
        String[] options = new String[] {"Neustarten", "Schließen"};
        JOptionPane.showOptionDialog(
        fenster,
        "Unentschieden",
        "5inf_TicTacToe",
        JOptionPane.DEFAULT_OPTION,
        JOptionPane.INFORMATION_MESSAGE,
        null,
        options,
        options[0]
        );
    }
    
    private void Gewinner(SYMBOLE gewinner)
    {
        String[] options = new String[] {"Neustarten", "Schließen"};
        String gewinner_string = gewinner.name() + " hat das Spiel gewonnen! Herzlichen Glühwein!";
        JOptionPane.showOptionDialog(
        fenster,
        gewinner_string,
        "5inf_TicTacToe",
        JOptionPane.DEFAULT_OPTION,
        JOptionPane.INFORMATION_MESSAGE,
        null,
        options,
        options[0]
        );
    }
    
    public FELDANZEIGE FeldanzeigeGeben()
    {
        return feldanzeige;
    }

}
