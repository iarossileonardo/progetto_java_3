package progetto_java_3;

class Produttore extends Thread {
    private Risorsa r;
    private boolean running;

    Produttore(Risorsa r, String name) {
        super(name);
        this.r = r;
        running = true;
    }

    public void arresta() {
        this.running = false;
    }

    public void run() {
        String name = Thread.currentThread().getName();
        try {
            while (running) {
                int val = (int) (Math.random() * 100 + 1);
                System.out.println(name + " produce:  " + val);
                r.produci(val);
            }
            System.out.println("Fine thread " + name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}