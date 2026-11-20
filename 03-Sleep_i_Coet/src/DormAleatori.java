public class DormAleatori extends Thread {
    private long tempsCreacio;

    public DormAleatori(String nom) {
        super(nom); 
        this.tempsCreacio = System.currentTimeMillis();
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int intervalAleatori = (int) (Math.random() * 1000);
            
            long tempsTotal = System.currentTimeMillis() - tempsCreacio;

            System.out.printf("%-4s(%d) a dormir %5dms total %6dms%n", getName(), i, intervalAleatori, tempsTotal);
            try {
                Thread.sleep(intervalAleatori);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        DormAleatori joan = new DormAleatori("Joan");
        DormAleatori pep = new DormAleatori("Pep");

        joan.start();
        pep.start();

        System.out.println("-- Fi de main -----------");
    }
}