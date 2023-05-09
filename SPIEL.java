public class SPIEL {
    
    private FENSTER fenster;
    private MAUSLISTENER mauslistener;
    
    public SPIEL(){
        mauslistener = new MAUSLISTENER();
        fenster = new FENSTER(mauslistener);
        
    }

}
