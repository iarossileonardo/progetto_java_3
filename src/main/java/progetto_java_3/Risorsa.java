package progetto_java_3;

class Risorsa {
    private int val;
    private boolean prodD;
    private boolean consD;

    Risorsa() {
        prodD = true;
        consD = false;
    }

    public synchronized void produci(int val) {
        try {
            while(!prodD){
                wait();
            }
        } catch (Exception e) {}
        prodD = false;
        consD = true;
        notifyAll();
        this.val = val;
    }

    public synchronized int consuma() {
        try {
            while(!consD){
                wait();
            }
        } catch (Exception e) {}
        consD = false;
        prodD = true;
        notifyAll();
        return this.val;
    }

    public boolean isProdD() {
        return prodD;
    }

    public boolean isConsD() {
        return consD;
    }

    
}