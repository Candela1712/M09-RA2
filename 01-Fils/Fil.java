public class Fil extends Thread {
    private String nom;
    private boolean estricte;

    private static final Object bloqueig = new Object();
    private static String torn = "Juan";

    public Fil(String nom, int prioritat, boolean estricte) {
        this.nom = nom;
        this.estricte = estricte;
        this.setPriority(prioritat);
    }
    
    @Override 
    public void run() {
        for (int i = 1; i <= 9; i++) {
            if (estricte) {
                synchronized (bloqueig) {
                    while (!torn.equals(nom)) {
                        try {
                            bloqueig.wait();
                        } catch (InterruptedException e) {
                            return;
                        }
                    }
                    System.out.println(nom + " " + i);
                    if (nom.equals("Juan")) {
                        torn = "Pepe";
                    } else {
                        torn = "Juan";
                    }
                    bloqueig.notifyAll();
                }
            } else {
                System.out.println(nom + " " + i);

                for (int j = 0; j < 1000; j++) {
                    int x = j * j;
                }
            }
        }
        if (estricte) {
            System.out.println("Termina el fil " + nom);
        } else {
            System.out.println("Acaba el fil " + nom);
        }
    }
}