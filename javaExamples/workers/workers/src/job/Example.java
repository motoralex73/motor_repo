package job;

public class Example {
    public static void main(String[] args) throws InterruptedException {
        TaskManager taskManager = new TaskManager();
        taskManager.addTask(new Job() {
            @Override
            public void run() {
                System.out.println("task 1");
            }
        });
        taskManager.addTask(new Job() {
            @Override
            public void run() {
                System.out.println("task 2");
            }
        });
        taskManager.addTask(new Job() {
            @Override
            public void run() {
                System.out.println("task 3");
            }
        });

        taskManager.run();
    }
}
