import javax.swing.*;
import java.awt.*;

public class FinestraGioco extends JFrame
{
    // Attributi
    private JButton[][] bottoni;
    private Partita partita;
    private JButton btnReset;
    private JLabel labelTurno;

    /**
     * @param player1 player della partita
     * @param player2 player della partita
     */
    public FinestraGioco(Player player1, Player player2)
    {
        partita = new Partita(player1, player2);
        bottoni = new JButton[3][3];

        setTitle("TRIS");
        setSize(420, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Etichetta turno corrente in alto
        labelTurno = new JLabel("Turno: " + partita.getTurnoCorrente().getUsername() + " (" + partita.getTurnoCorrente().getSimbolo() + ")", SwingConstants.CENTER);
        labelTurno.setFont(new Font("Arial", Font.BOLD, 16));
        labelTurno.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(labelTurno, BorderLayout.NORTH);

        // Griglia 3x3
        JPanel jpanel = new JPanel();
        jpanel.setLayout(new GridLayout(3, 3, 5, 5));
        jpanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                JButton btn = new JButton("");
                btn.setFont(new Font("Arial", Font.BOLD, 48));
                int r = i;
                int c = j;
                btn.addActionListener(e -> gestisciClick(r, c, btn));
                bottoni[i][j] = btn;
                jpanel.add(btn);
            }
        }
        add(jpanel, BorderLayout.CENTER);

        // Bottone reset in basso, inizialmente disabilitato
        btnReset = new JButton("Nuova Partita");
        btnReset.setEnabled(false);
        btnReset.setFont(new Font("Arial", Font.PLAIN, 14));
        btnReset.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        btnReset.addActionListener(e -> resetPartita());

        JPanel panelSud = new JPanel();
        panelSud.add(btnReset);
        add(panelSud, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void gestisciClick(int riga, int colonna, JButton btn)
    {
        if (partita.isFinita()) return;

        boolean ok = partita.gioca(riga, colonna);
        if (!ok) return;

        btn.setText(String.valueOf(partita.getGriglia().getSimbolo(riga, colonna)));

        if (partita.isFinita())
        {
            btnReset.setEnabled(true);

            if (partita.getStato() == StatoPartita.VITTORIA)
            {
                evidenziaCelleVincenti();
                labelTurno.setText("Ha vinto: " + partita.getVincitore().getUsername()
                        + " (" + partita.getVincitore().getSimbolo() + ")");
                JOptionPane.showMessageDialog(this,
                        "Ha vinto " + partita.getVincitore().getUsername() + "!");
            }
            else if (partita.getStato() == StatoPartita.PAREGGIO)
            {
                labelTurno.setText("Pareggio!");
                JOptionPane.showMessageDialog(this, "Pareggio!");
            }
        }
        else
        {
            // Aggiorna etichetta turno
            labelTurno.setText("Turno: " + partita.getTurnoCorrente().getUsername()
                    + " (" + partita.getTurnoCorrente().getSimbolo() + ")");
        }
    }

    /**
     * Colora di verde le tre celle della combinazione vincente.
     */
    private void evidenziaCelleVincenti()
    {
        int[][] celle = partita.getGriglia().getCelleVincenti();
        if (celle == null) return;
        for (int[] cella : celle)
        {
            bottoni[cella[0]][cella[1]].setBackground(Color.GREEN);
            bottoni[cella[0]][cella[1]].setOpaque(true);
        }
    }

    /**
     * Resetta la griglia visiva e la logica della partita, mantenendo i giocatori.
     */
    private void resetPartita()
    {
        partita.reset();
        btnReset.setEnabled(false);

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                bottoni[i][j].setText("");
                bottoni[i][j].setBackground(null);
                bottoni[i][j].setOpaque(false);
            }
        }

        labelTurno.setText("Turno: " + partita.getTurnoCorrente().getUsername()
                + " (" + partita.getTurnoCorrente().getSimbolo() + ")");
    }
}