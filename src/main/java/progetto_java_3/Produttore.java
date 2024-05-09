package progetto_java_3;

class Produttore extends Thread {
    private Risorsa r;
    private boolean running;

    Produttore(Risorsa r, String name) {
        super(name);
        this.r = r;
        running = true;
    }

    public synchronized void arresta() {
        this.running = false;
        r.setProdD(true);
        notifyAll();
    }

    public void run() {
        String name = Thread.currentThread().getName();
        try {
            while (running) {
                int val = (int) (Math.random() * 100 + 1);
                r.produci(val);
                System.out.println(name + " produce:  " + val);
            }
            System.out.println("Fine thread " + name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}