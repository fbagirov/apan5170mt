class Task implements Runnable {
    private int id;

    public Task(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Task " + id + " started by " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000); // simulate work
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task " + id + " completed");
    }
}