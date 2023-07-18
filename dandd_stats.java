import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class DnDStatsGUI {
    private static int finalSumod;
    private static Random random = new Random();
    private static int tableCounter = 0;
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
                dado[i] = random.nextInt(6) + 1;
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
        JFrame frame = new JFrame("D&D Stats");

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel titlePanel = new JPanel();
        titlePanel.add(new JLabel("Calcolatore statistiche Dungeons & Dragons 3.5!!!"));
        mainPanel.add(titlePanel);

        JTextArea resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        mainPanel.add(scrollPane);

        JButton start = new JButton("Avvia");
        JButton riprova = new JButton("Riprova");
        riprova.setVisible(false);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultArea.setText("Ecco i risultati:\n");
                int[] tabella = stats();
                for (int i = 0; i < 6; i++) {
                    resultArea.append(tabella[i] + " con corrispettivo modificatore: " + ((tabella[i] - 10) / 2) + "\n");
                }
                resultArea.append("Somma dei modificatori: " + finalSumod + "\n");
                resultArea.append("\n");
                if (finalSumod < 8) {
                    resultArea.append("La somma dei modificatori non è abbastanza alta\n");
                    resultArea.append("Riprovare!!!\n");
                } else if (tableCounter < 3) { // Limita il numero massimo di schede a 3
                    JPanel tablePanel = new JPanel();
                    tablePanel.setLayout(new BoxLayout(tablePanel, BoxLayout.Y_AXIS));
                    for (int i = 0; i < 6; i++) {
                        tablePanel.add(new JLabel(tabella[i] + " con corrispettivo modificatore: " + ((tabella[i] - 10) / 2)));
                    }
                    tabbedPane.addTab("Risultato " + (tableCounter + 1), tablePanel);
                    tableCounter++;
                }
                start.setVisible(false);
                riprova.setVisible(true);
            }
        });
        riprova.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultArea.setText("Ecco i risultati:\n");
                int[] tabella = stats();
                for (int i = 0; i < 6; i++) {
                    resultArea.append(tabella[i] + " con corrispettivo modificatore: " + ((tabella[i] - 10) / 2) + "\n");
                }
                resultArea.append("Somma dei modificatori: " + finalSumod + "\n");
                resultArea.append("\n");
                if (finalSumod < 8) {
                    resultArea.append("La somma dei modificatori non è abbastanza alta\n");
                    resultArea.append("Riprovare!!!\n");
                } else if (tableCounter < 3) { // Limita il numero massimo di schede a 3
                    JPanel tablePanel = new JPanel();
                    tablePanel.setLayout(new BoxLayout(tablePanel, BoxLayout.Y_AXIS));
                    for (int i = 0; i < 6; i++) {
                        tablePanel.add(new JLabel(tabella[i] + " con corrispettivo modificatore: " + ((tabella[i] - 10) / 2)));
                    }
                    tabbedPane.addTab("Risultato " + (tableCounter + 1), tablePanel);
                    tableCounter++;
                    if (tableCounter == 3) {
                        riprova.setVisible(false);
                        resultArea.append("Scegliere uno dei 3 risultati");
                    }
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(start);
        buttonPanel.add(riprova);

        mainPanel.add(buttonPanel);

        tabbedPane.addTab("Calcolatore", mainPanel);

        frame.getContentPane().add(tabbedPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}