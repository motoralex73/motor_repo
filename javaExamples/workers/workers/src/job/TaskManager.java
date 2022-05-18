package job;

import java.util.ArrayList;
import java.util.List;

public class TaskManager <T extends Job> {
    List<T> tasks = new ArrayList<>();

    public void addTask(T task) {
        tasks.add(task);
    }

    public void run() throws InterruptedException {
        while (true) {
            tasks.forEach(tt -> tt.run());
            Thread.sleep(1000);
        }
    }
}