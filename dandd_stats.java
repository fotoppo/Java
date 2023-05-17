public class dandd_stats {
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
}