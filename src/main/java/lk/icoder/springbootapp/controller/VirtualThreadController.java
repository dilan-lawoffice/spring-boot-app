import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class VirtualThreadController {
    
    private final ExecutorService executorService;

    public VirtualThreadController() {
        this.executorService = Executors.newVirtualThreadPerTaskExecutor();
    }

    @GetMapping("/virtual-thread-example")
    public String virtualThreadExample() {
        System.out.println("vt....");
        executorService.submit(() -> {
            try {
                // Simulate a long-running task
                Thread.sleep(2000);
                System.out.println("Task executed in a virtual thread: " + 
                Thread.currentThread().getName());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        return "Task submitted to virtual thread!";
    }

    
}