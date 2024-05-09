package progetto_java_3;

class Consumatore extends Thread {
    private Risorsa r;
    private boolean running;

    Consumatore(Risorsa r, String name) {
        super(name);
        this.r = r;
        running = true;
    }

    public synchronized void arresta() {
        running = false;
    }

    public void run() {
        String name = Thread.currentThread().getName();
        try {
            while (running) {
                this.sleep(1000);
                int val = r.consuma();
                //System.out.println(name + " consuma:  " + val);
            }
            System.out.println("Fine thread " + name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}