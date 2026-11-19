public class Futbolista extends Thread {
    public static final int NUM_JUGADORS = 11;
    public static final int NUM_TIRADES = 20;
    public static final float PROBABILITAT = 0.5f;

    private int ngols;
    private int ntirades;

    public Futbolista(String nom) {
        super(nom); 
        this.ngols = 0;
        this.ntirades = 0;
    }

    public int getNgols() {
        return ngols;
    }

    public int getNtirades() {
        return ntirades;
    }
    @Override
    public void start() {
        for (int i = 0; i < NUM_TIRADES; i++) {
            ntirades++;
            if (Math.random() < PROBABILITAT) {
                ngols++;
            }
        }
    }
    public static void main(String[] args) {
        String[] noms = {"Piqué", "Vinicius", "Torres", "Ramos", "Ronaldo", 
                         "Lewan", "Belli", "Arnau", "Aspas", "Messi", "MBapé"};
        
        Futbolista[] jugadors = new Futbolista[NUM_JUGADORS];
        for (int i = 0; i < jugadors.length; i++) {
            jugadors[i] = new Futbolista(noms[i]);
        }
        System.out.println("Inici dels xuts --------------------");
        
        for (int i = 0; i < jugadors.length; i++) {
            jugadors[i].start();
        }

        for (int i = 0; i < jugadors.length; i++) {
            try {
                jugadors[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Fi dels xuts -----------------------");
        System.out.println("--- Estadístiques ------");

        for (int i = 0; i < jugadors.length; i++) {
            System.out.printf("%-10s -> %d gols%n", jugadors[i].getName(), jugadors[i].getNgols());
        }
    }
    
}
