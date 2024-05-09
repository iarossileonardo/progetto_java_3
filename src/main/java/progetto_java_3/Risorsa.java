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
                System.out.println("prod attende");
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
                System.out.println("cons attende");
                wait();
            }
        } catch (Exception e) {}
        System.out.println(Thread.currentThread().getName() + " consuma:  " + val);
        prodD = true;
        consD = false;
        notifyAll();
        return this.val;
    }

    public boolean isProdD() {
        return prodD;
    }

    

    public void setProdD(boolean prodD) {
        this.prodD = prodD;
    }

    public void setConsD(boolean consD) {
        this.consD = consD;
    }

    public boolean isConsD() {
        return consD;
    }

    
}