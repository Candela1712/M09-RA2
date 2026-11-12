public class PrincipalDiferents {
    public static void main(String[] args) {

        Fil pepe = new Fil("Pepe", Thread.MIN_PRIORITY, false);
        Fil juan = new Fil("Juan", Thread.MAX_PRIORITY, false);

        pepe.start();
        juan.start();

        System.out.println("Acaba thread main");
    }
}
