
public class SPIEL{

    private FENSTER fenster;
    private MAUSLISTENER mauslistener;
    private SYMBOLE spieler;
    private FELDLISTE feldliste;
    
    public SPIEL(){
        mauslistener = new MAUSLISTENER();
        spieler = SYMBOLE.O;
        feldliste = new FELDLISTE();
    }
    
    public void SpielStarten()
    {
        fenster = new FENSTER(mauslistener);
    }
    
    public void Klick(int x, int y)
    {
        int feld = feldliste.Suchen(x, y);
        System.out.println("Feld: " + feld);
        System.out.println("Spieler: " + spieler);
        if (spieler == SYMBOLE.O)
        {
            spieler = SYMBOLE.X;
        } else {
            spieler = SYMBOLE.O;
        }
    }
}
