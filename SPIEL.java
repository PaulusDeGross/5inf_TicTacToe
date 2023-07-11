
import javax.swing.JOptionPane;

public class SPIEL{

    private FENSTER fenster;
    private MAUSLISTENER mauslistener;
    private SYMBOLE spieler;
    private FELDLISTE feldliste;
    private FELDANZEIGE feldanzeige;
    private KREISANZEIGE kreisanzeige;
    private KREUZANZEIGE kreuzanzeige;
    private STATUSANZEIGE statusanzeige;
    private int platziert_zaehler;
    
    private int[][][] gewinnkombinationen;
    
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
        statusanzeige = new STATUSANZEIGE(fenster.LeinwandGeben());
        statusanzeige.Loeschen(KONST.fensterbreite, KONST.offset);
        gewinnkombinationen = gewinnKombinationenGenerieren();
        statusanzeige.Anzeigen(30, KONST.actionbar_offset + 30, "Spieler: " + spieler.name(), 30);
        feldliste = new FELDLISTE();
        platziert_zaehler = 0;
        for(int x = 0; x < KONST.spielfeldgroesse; x++)
        {
            for(int y = 0; y < KONST.spielfeldgroesse; y++)
            {
                feldanzeige.Loeschen(x, y);
                feldanzeige.Zeichnen(x * KONST.feldgroesse + KONST.feld_x_offset, KONST.feld_y_offset + KONST.offset + y * KONST.feldgroesse, KONST.feldgroesse, KONST.feldgroesse);
            }
        }

        gewinnKombinationenGenerieren();

        fenster.repaint();
    }

    public void Klick(int x, int y)
    {
        int feld = feldliste.Suchen(x, y);
        // System.out.println("Feld: " + feld + "| Spieler: " + spieler);
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
        statusanzeige.Loeschen(KONST.fensterbreite, KONST.offset);
        statusanzeige.Anzeigen(30, KONST.actionbar_offset + 30, "Spieler: " + spieler.name(), 30); 
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
        SYMBOLE gewinner = SpielEvaluieren();
        if(gewinner != null && platziert_zaehler < KONST.spielfeldgroesse * KONST.spielfeldgroesse || gewinner != null)
        {
            Gewinner(gewinner);
        }
        else if (gewinner == null && platziert_zaehler >= KONST.spielfeldgroesse * KONST.spielfeldgroesse)
        {
            Unentschieden();
        }
        // System.out.println(platziert_zaehler);
    }

    private SYMBOLE SpielEvaluieren()
    {   
        SYMBOLE[][] symbolliste = feldlisteZuSymbolliste();
        
        for(int i = 0; i < gewinnkombinationen.length; i++){
            SYMBOLE[] reihe = new SYMBOLE[gewinnkombinationen[i].length];
            for(int j = 0; j < gewinnkombinationen[i].length; j++){
                int feld_y = gewinnkombinationen[i][j][0];
                int feld_x = gewinnkombinationen[i][j][1];
                
                reihe[j] = symbolliste[feld_y][feld_x];
            }
            for(int x = 0; x < reihe.length; x++){
                if(IstAllesGleich(reihe)){
                    if(reihe[0] != SYMBOLE.LEER){
                        return reihe[0];
                    }
                }
            }
        }
        
        
        return null;
    }

    private int[][][] gewinnKombinationenGenerieren()
    {
        int anzahl_gewinnkombinationen = 2 * KONST.spielfeldgroesse + 2;
        System.out.println(anzahl_gewinnkombinationen);
        int[][][] gewinnkombinationen = new int[anzahl_gewinnkombinationen][KONST.spielfeldgroesse][2];
        for(int i = 0; i < anzahl_gewinnkombinationen; i++){
            int coord_y = i % KONST.spielfeldgroesse;
            if(i < 2 * KONST.spielfeldgroesse){
                for(int j = 0; j < KONST.spielfeldgroesse; j++){
                    if(i < KONST.spielfeldgroesse){
                        gewinnkombinationen[i][j][0] = j;
                        gewinnkombinationen[i][j][1] = coord_y;
                    }else{
                        gewinnkombinationen[i][j][0] = coord_y;
                        gewinnkombinationen[i][j][1] = j;
                    }

                    if(coord_y == j){
                        gewinnkombinationen[anzahl_gewinnkombinationen - 1][j][0] = coord_y;
                        gewinnkombinationen[anzahl_gewinnkombinationen - 1][j][1] = j;

                        gewinnkombinationen[anzahl_gewinnkombinationen - 2][j][0] = j;
                        gewinnkombinationen[anzahl_gewinnkombinationen - 2][KONST.spielfeldgroesse - j - 1][1] = coord_y;
                    }
                }
            }
        }

        return gewinnkombinationen;
    }

    private SYMBOLE[][] feldlisteZuSymbolliste()
    {
        int feld_laenge = feldliste.LaengeGeben();
        SYMBOLE[][] zustaende = new SYMBOLE[KONST.spielfeldgroesse][KONST.spielfeldgroesse];
        for(int i = 0; i < feld_laenge; i++)
        {   
            int reihe = i / KONST.spielfeldgroesse;
            int spalte = i % KONST.spielfeldgroesse;

            zustaende[reihe][spalte] = feldliste.SymbolGeben(i);
        }

        return zustaende;
    }

    private void Unentschieden()
    {
        String[] options = new String[] {"Neustarten", "Schließen"};
        int selected = JOptionPane.showOptionDialog(
                fenster,
                "Unentschieden",
                "5inf_TicTacToe",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]
            );
        if(selected == 0)
        {
            Initialisieren();
        }
        else
        {
            System.exit(-1);
        }
    }

    private void Gewinner(SYMBOLE gewinner)
    {
        String[] options = new String[] {"Neustarten", "Schließen"};
        String gewinner_string = gewinner.name() + " hat das Spiel gewonnen! Herzlichen Glühwein!";
        int selected = JOptionPane.showOptionDialog(
                fenster,
                gewinner_string,
                "5inf_TicTacToe",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]
            );
        if(selected == 0)
        {
            Initialisieren();
        }
        else
        {
            System.exit(-1);
        }
    }

    public FELDANZEIGE FeldanzeigeGeben()
    {
        return feldanzeige;
    }

    private boolean IstAllesGleich(SYMBOLE[] symbolliste)
    {
        for(int i = 0; i < symbolliste.length; i++){
            if(symbolliste[0] != symbolliste[i])
            {
                return false;
            }
        }
        return true;
    }

}
