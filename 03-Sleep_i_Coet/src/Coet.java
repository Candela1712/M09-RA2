import java.util.Scanner;
public class Coet {
    private Motor[] motors = new Motor[4];

    public Coet() {
        for (int i = 0; i < motors.length; i++) {
            motors[i] = new Motor("Motor " + i);
        }
    }

    public void arranca() {
        for (int i = 0; i < motors.length; i++) {
            motors[i].start();
        }
    }

    public void passaAPotencia(int p) {
        if (p < 0 || p > 10) {
            System.out.println("Error: La potència ha d'estar entre 0 i 10.");
            return;
        }
        System.out.println("Passant a potència " + p);
        for (int i = 0; i < motors.length; i++) {
            motors[i].setPotencia(p);
        }
    }
    public static void main(String[] args) {
        Coet coet = new Coet();
        coet.arranca();

        Scanner sc = new Scanner(System.in);
        int potencia = -1;

        while (potencia != 0) {
            if (sc.hasNextInt()) {
                potencia = sc.nextInt();
                coet.passaAPotencia(potencia);
            } else {
                sc.next();
            }
        }
        sc.close();
    }
}