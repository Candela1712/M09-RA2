public class PrincipalEstricta {
    public static void main(String[] args) {

        Fil juan = new Fil("Juan", Thread.NORM_PRIORITY, true);
        Fil pepe = new Fil("Pepe", Thread.NORM_PRIORITY, true);

        juan.start();
        pepe.start();

        System.out.println("Termina thread main");
    }
}
