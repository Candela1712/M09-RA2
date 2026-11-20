public class Motor extends Thread {
    private int potenciaActual = 0;
    private int potenciaObjectiu = 0;
    private boolean enMarxa = false;

    public Motor(String nom) {
        super(nom);
    }

    public void setPotencia(int p) {
        this.potenciaObjectiu = p;
        if (p > 0) {
            this.enMarxa = true;
        }
    }
    @Override
    public void run() {
        while (true) {
            int tempsResposta = 1000 + (int) (Math.random() * 1001);

            if (potenciaActual < potenciaObjectiu) {
                dormir(tempsResposta);
                potenciaActual++;
                System.out.println(getName() + ": Incre. Objectiu: " + potenciaObjectiu + " Actual: " + potenciaActual);
                
            } else if (potenciaActual > potenciaObjectiu) {
                dormir(tempsResposta);
                potenciaActual--;
                System.out.println(getName() + ": Decre. Objectiu: " + potenciaObjectiu + " Actual: " + potenciaActual);
                
            } else {
                if (enMarxa && potenciaObjectiu == 0) {
                    System.out.println(getName() + ": FerRes Objectiu: " + potenciaObjectiu + " Actual: " + potenciaActual);
                    break; 
                }
                dormir(500);
            }
        }
    }
    private void dormir(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}