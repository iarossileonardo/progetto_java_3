package progetto_java_3;

public class Main {
    public static void main(String[] args) {
        Risorsa r = new Risorsa();
        Produttore p = new Produttore(r, "PROD");
        Consumatore c = new Consumatore(r, "CONS");
        p.start();
        c.start();
        // Aspetto 5 secondi poi termino i thread
        try {
            Thread.sleep(5000);
            System.out.println("TEMPO FINITO");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        p.arresta();
        c.arresta();
    }
}