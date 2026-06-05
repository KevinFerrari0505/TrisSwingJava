public class Griglia
{
    //Attributi
    private char[][] griglia;

    /**
     * costruisce la griglia del Tris
     */
    public Griglia()
    {
        griglia = new char[3][3];
        reset();
    }

    /**
     * metodo reset che pulisce la griglia ogni volta che si inizia una nuova partita
     */
    public void reset()
    {
        for(int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                griglia[i][j] = ' ';
            }
        }
    }

    /**
     *
     * @return true se uno dei due giocatori ha fatto tris. False altrimenti che rappresenta il pareggio
     */
    public boolean controllaVittoria()
    {
        //Tris in orizzontale nella prima riga
        if(griglia[0][0] != ' ' &&  griglia[0][0] == griglia[0][1] && griglia[0][1] == griglia[0][2]) return true;
        //Tris in orizzontale nella seconda riga
        if(griglia[1][0] != ' ' && griglia[1][0] == griglia[1][1] && griglia[1][1] == griglia[1][2]) return true;
        //Tris in orizzontale nella terza riga
        if(griglia[2][0] != ' ' && griglia[2][0] == griglia[2][1] && griglia[2][1] == griglia[2][2]) return true;

        //Tris in verticale sulla prima colonna
        if(griglia[0][0] != ' ' && griglia[0][0] == griglia[1][0] && griglia[1][0] == griglia[2][0]) return true;
        //Tris in verticale sulla seconda colonna
        if(griglia[0][1] != ' ' && griglia[0][1] == griglia[1][1] && griglia[1][1] == griglia[2][1]) return true;
        //Tris in verticale sulla terza colonna
        if(griglia[0][2] != ' '&& griglia[0][2] == griglia[1][2] && griglia[1][2] == griglia[2][2]) return true;

        //Tris in diagonale da sinistra a destra
        if(griglia[0][0] != ' ' && griglia[0][0] == griglia[1][1] && griglia[1][1] == griglia[2][2]) return true;
        //Tris in diagonale da destra a sinistra
        if(griglia[0][2] != ' ' &&  griglia[0][2] == griglia[1][1] &&  griglia[1][1] == griglia[2][0])  return true;

        return false; //Nessun Tris
    }

    /**
     *
     * @return false se la griglia è vuota. Altrimenti ritorno l'opposto di controllaVittoria
     */
    public boolean controllaPareggio()
    {
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                if(griglia[i][j] == ' ')
                    return false;
            }
        }

        return !controllaVittoria();
    }

    /**
     *
     * @param riga riga della griglia
     * @param colonna colonna della griglia
     * @param simbolo simbolo che vuole inserire l'utente
     * @return true se il simbolo viene inserito correttamente nella griglia, false altrimenti
     */
    public boolean inserisciSimbolo(int riga, int colonna, char simbolo)
    {
        if(riga < 0 || riga >= griglia.length) return false;
        if(colonna < 0 || colonna >= griglia.length) return false;
        if(griglia[riga][colonna] != ' ') return false; //cella già piena
        if(simbolo == ' ') return false;
        if(simbolo != 'X' && simbolo != 'O') return false;
        griglia[riga][colonna] = simbolo;
        return true;

    }

    /**
     *
     * @param riga riga della griglia
     * @param colonna colonna della griglia
     * @return il simbolo della griglia
     */
    public char getSimbolo(int riga, int colonna)
    {
        return griglia[riga][colonna];
    }


    /**
     * @return array di int[2] con le coordinate [riga, colonna] delle 3 celle vincenti,
     *         oppure null se non c'è ancora nessuna vittoria
     */
    public int[][] getCelleVincenti()
    {
        // Righe orizzontali
        for(int i = 0; i < 3; i++)
        {
            if(griglia[i][0] != ' ' && griglia[i][0] == griglia[i][1] && griglia[i][1] == griglia[i][2])
                return new int[][]{{i,0},{i,1},{i,2}};
        }
        // Colonne verticali
        for(int j = 0; j < 3; j++)
        {
            if(griglia[0][j] != ' ' && griglia[0][j] == griglia[1][j] && griglia[1][j] == griglia[2][j])
                return new int[][]{{0,j},{1,j},{2,j}};
        }
        // Diagonale principale
        if(griglia[0][0] != ' ' && griglia[0][0] == griglia[1][1] && griglia[1][1] == griglia[2][2])
            return new int[][]{{0,0},{1,1},{2,2}};
        // Diagonale secondaria
        if(griglia[0][2] != ' ' && griglia[0][2] == griglia[1][1] && griglia[1][1] == griglia[2][0])
            return new int[][]{{0,2},{1,1},{2,0}};

        return null;
    }

    /**
     *
     * @return la stampa della griglia
     */
    @Override
    public String toString()
    {
        String s = "";

        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                s += "[" + griglia[i][j] + "]";
            }
            s += "\n";
        }

        return s;
    }
}
