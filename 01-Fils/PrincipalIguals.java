public class PrincipalIguals {
    public static void main(String[] args) {

        Fil juan = new Fil("Juan", Thread.NORM_PRIORITY, false);
        Fil pepe = new Fil("Pepe", Thread.NORM_PRIORITY, false);

        juan.start();
        pepe.start();

        System.out.println("Acaba thread main");
    }
}
