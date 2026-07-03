import javax.swing.*;
import java.awt.*;

public class FinestraIniziale extends JFrame
{
    private JTextField nome1;
    private JTextField nome2;

    public FinestraIniziale()
    {
        setTitle("Inserisci giocatori");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        nome1 = new JTextField();
        nome2 = new JTextField();

        JButton gioca = new JButton("Gioca");

        setLayout(new GridLayout(3, 2));

        add(new JLabel("Player 1:"));
        add(nome1);

        add(new JLabel("Player 2:"));
        add(nome2);

        add(new JLabel(""));
        add(gioca);

        gioca.addActionListener(e -> avviaGioco());

        setVisible(true);
    }

    private void avviaGioco()
    {
        String n1 = nome1.getText().trim();
        String n2 = nome2.getText().trim();

        if(n1.length() < 2 || n2.length() < 2)
        {
            JOptionPane.showMessageDialog(this, "Nomi non validi");
            return;
        }

        Player p1 = new Player(n1, 'X');
        Player p2 = new Player(n2, 'O');

        new FinestraGioco(p1, p2);

        this.dispose(); // chiude la finestra iniziale
    }
}