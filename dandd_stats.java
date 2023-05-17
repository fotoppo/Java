/*public class dandd_stats {
    public static void main(String[] args) {
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
            giatolto = false;
            sumod += mod;
            System.out.println("Le stats sono: " + tabella[j] + " e i modificatori sono: " + mod);
        }
        System.out.println("somma dei modificatori: " + sumod);
    }
}*/

import javax.swing.*;

public class DnDStatsGUI {
    public static void main(String[] args) {
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
            giatolto = false;
            sumod += mod;
            System.out.println("Le stats sono: " + tabella[j] + " e i modificatori sono: " + mod);
        }
        System.out.println("somma dei modificatori: " + sumod);

        // Creazione finestra grafica
        JFrame frame = new JFrame("D&D Stats");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creazione e configurazione del pannello
        JPanel panel = new JPanel();
        panel.add(new JLabel("Le stats sono: " + tabella[0] + ", " + tabella[1] + ", " + tabella[2] + ", " + tabella[3]
                + ", " + tabella[4] + ", " + tabella[5]));
        panel.add(new JLabel("I modificatori sono: " + ((tabella[0] - 10) / 2) + ", " + ((tabella[1] - 10) / 2) + ", "
                + ((tabella[2] - 10) / 2) + ", " + ((tabella[3] - 10) / 2) + ", " + ((tabella[4] - 10) / 2) + ", "
                + ((tabella[5] - 10) / 2)));
        panel.add(new JLabel("Somma dei modificatori: " + sumod));

        // Aggiunta del pannello alla finestra
        frame.getContentPane().add(panel);

        // Impostazione delle dimensioni e visualizzazione della finestra
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
