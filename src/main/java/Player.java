public class Player
{
    //Attributi
    private String username;
    private char simbolo;

    /**
     *
     * @param username username del player
     * @param simbolo simbolo associato al player
     */
    public Player(String username, char simbolo)
    {
        if(username == null) throw new NullPointerException("username null");
        if(username.trim().length() < 2) throw new IllegalArgumentException("Username non valido");
        if(simbolo != 'X' && simbolo != 'O') throw new IllegalArgumentException("simbolo non valido");
        this.username = username;
        this.simbolo = simbolo;
    }

    /**
     *
     * @return l'username del player
     */
    public String getUsername()
    {
        return this.username;
    }

    /**
     *
     * @return il simbolo del player
     */
    public char getSimbolo()
    {
        return this.simbolo;
    }

    /**
     *
     * @return la stampa del player
     */
    public String toString()
    {
        return "Nome Player: " + username + " simbolo: " + simbolo;
    }
}
