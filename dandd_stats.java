import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DnDStatsGUI {
    private static int finalSumod;
    private static int[] stats() {
        int[] tabella = new int[6];
        int[] dado = new int[4];
        int minore = 6, sumod = 0;
        boolean giatolto;

        for (int j = 0; j < tabella.length; j++) {
            int risdado = 0;
            int mod = 0;
            giatolto = false;

            for (int i = 0; i < dado.length; i++) {
                dado[i] = (int) (Math.random() * 6) + 1;
                if (minore > dado[i]) {
                    minore = dado[i];
                }
            }

            for (int i = 0; i < dado.length; i++) {
                if (dado[i] == minore && !giatolto) {
                    dado[i] = 0;
                    giatolto = true;
                }
                risdado += dado[i];
            }

            tabella[j] = risdado;

            if (risdado >= 4 && risdado <= 19) {
                mod = (risdado - 10) / 2;
            }

            minore = 6;
            sumod += mod;
            System.out.println("Le stats sono: " + tabella[j] + " e i modificatori sono: " + mod);
        }
        System.out.println("somma dei modificatori: " + sumod);
        finalSumod = sumod;
        return tabella;
    }
    public static void main(String[] args) {
        // Creazione finestra grafica
        JFrame frame = new JFrame("D&D Stats");
        JPanel panel = new JPanel();
        JPanel ButtonPanel = new JPanel();
        panel.add(new JLabel("Calcolatore statistiche Dungeons & Dragons!!!"));
        JButton start = new JButton("Avvia");
        JButton riprova = new JButton("Riprova");
        start.setBounds(150,150,95,30);
        riprova.setBounds(125, 150, 95, 30);
        frame.add(start);
        int[] tabella = stats();
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Creazione e configurazione del pannello
                panel.removeAll();
                panel.add(new JLabel("Ecco i risultati:     "));
                for(int i = 0; i < 6; i++) {
                    panel.add(new JLabel(tabella[i] + " con corrispettivo modificatore: " + ((tabella[i] -10) / 2)));
                }
                /*panel.add(new JLabel(tabella[0] + " con corrispettivo modificatore: " + ((tabella[0] - 10) / 2)));
                panel.add(new JLabel(tabella[1] + " con corrispettivo modificatore: " + ((tabella[1] - 10) / 2)));
                panel.add(new JLabel(tabella[2] + " con corrispettivo modificatore: " + ((tabella[2] - 10) / 2)));
                panel.add(new JLabel(tabella[3] + " con corrispettivo modificatore: " + ((tabella[3] - 10) / 2)));
                panel.add(new JLabel(tabella[4] + " con corrispettivo modificatore: " + ((tabella[4] - 10) / 2)));
                panel.add(new JLabel(tabella[5] + " con corrispettivo modificatore: " + ((tabella[5] - 10) / 2)));
                */
                panel.add(new JLabel("Somma dei modificatori: " + finalSumod));
                if(finalSumod < 8) {
                    panel.add(new JLabel("La somma dei modificatori non è abbastanza alta"));
                    panel.add(new JLabel("Riprovare!!!"));
                }
                panel.add(ButtonPanel);
                frame.getContentPane().remove(start);
                frame.setSize(360, 300);
            }
        });
        riprova.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stats();
                int[] tabella = stats();
                panel.removeAll();
                panel.add(new JLabel("Ecco i risultati:     "));
                for(int i = 0; i < 6; i++) {
                    panel.add(new JLabel(tabella[i] + " con corrispettivo modificatore: " + ((tabella[i] -10) / 2)));
                }
                /*panel.add(new JLabel(tabella[0] + " con corrispettivo modificatore: " + ((tabella[0] - 10) / 2)));
                panel.add(new JLabel(tabella[1] + " con corrispettivo modificatore: " + ((tabella[1] - 10) / 2)));
                panel.add(new JLabel(tabella[2] + " con corrispettivo modificatore: " + ((tabella[2] - 10) / 2)));
                panel.add(new JLabel(tabella[3] + " con corrispettivo modificatore: " + ((tabella[3] - 10) / 2)));
                panel.add(new JLabel(tabella[4] + " con corrispettivo modificatore: " + ((tabella[4] - 10) / 2)));
                panel.add(new JLabel(tabella[5] + " con corrispettivo modificatore: " + ((tabella[5] - 10) / 2)));
                */
                panel.add(new JLabel("Somma dei modificatori: " + finalSumod));
                if(finalSumod < 8) {
                    panel.add(new JLabel("La somma dei modificatori non è abbastanza alta"));
                    panel.add(new JLabel("Riprovare!!!"));
                }
                panel.revalidate();
                panel.repaint();
                panel.add(ButtonPanel);
            }
        });
        ButtonPanel.add(riprova);
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Impostazione delle dimensioni e visualizzazione della finestra
        frame.setSize(400, 300);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
