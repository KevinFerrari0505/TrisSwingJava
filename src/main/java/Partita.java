public class Partita
{
    //Attributi
    private Player player1;
    private Player player2;
    private Player turnoCorrente;
    private Griglia griglia;
    private boolean finita;
    private StatoPartita stato = StatoPartita.IN_CORSO;
    private Player vincitore = null;

    /**
     *
     * @param player1 player1 della partita tris
     * @param player2 player2 della partita tris
     */
    public Partita(Player player1, Player player2)
    {
        if(player1 == null || player2 == null) throw new NullPointerException("Player nulli");
        this.player1 = player1;
        this.player2 = player2;
        this.turnoCorrente = player1;
        this.griglia = new Griglia();
        finita = false;
    }

    /**
     *
     * @return il turno del player corrente
     */
    public Player getTurnoCorrente()
    {
        return turnoCorrente;
    }

    /**
     * cambia il turno del player
     */
    public void cambiaTurno()
    {
        if(turnoCorrente == player1) turnoCorrente = player2;
        else turnoCorrente = player1;
    }
    /**
     *
     * @return true se la partita è finita
     */
    public boolean isFinita()
    {
        return finita;
    }

    /**
     *
     * @return la griglia del tris
     */
    public Griglia getGriglia()
    {
        return griglia;
    }

    /**
     *
     * @return stato della partita
     */
    public StatoPartita getStato()
    {
        return stato;
    }

    /**
     * @return il player vincitore, oppure null se la partita è in corso o è un pareggio
     */
    public Player getVincitore()
    {
        return vincitore;
    }

    /**
     * Resetta la partita mantenendo gli stessi giocatori.
     * Il turno riparte sempre da player1.
     */
    public void reset()
    {
        griglia.reset();
        turnoCorrente = player1;
        finita = false;
        stato = StatoPartita.IN_CORSO;
        vincitore = null;
    }

    /**
     * gioca la partita
     */
    public boolean gioca(int riga, int colonna)
    {
        if(isFinita()) return false;

        boolean mossaValida = griglia.inserisciSimbolo(riga, colonna, turnoCorrente.getSimbolo());

        if(!mossaValida) return false;

        if(griglia.controllaVittoria())
        {
            finita = true;
            stato = StatoPartita.VITTORIA;
            vincitore = turnoCorrente;
            return true;
        }

        if(griglia.controllaPareggio())
        {
            finita = true;
            stato = StatoPartita.PAREGGIO;
            return true;
        }
        cambiaTurno();
        return true;

    }
}
