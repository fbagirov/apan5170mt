class Task implements Runnable {
    private int id;

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public Task(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Task " + id + " started by " + Thread.currentThread().getName());

        synchronized (lock1){
            System.out.println("Task" + id + "lock1");
        try {
            Thread.sleep(1000); // simulate work
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (lock2){
            System.out.println("Task" + id + "lock2");
        }
    }
        System.out.println("Task " + id + " completed");
    }
}
