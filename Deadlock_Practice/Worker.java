import java.util.Arrays;
import java.util.Comparator;

public class Worker extends Thread {
    private final int workerNumber;
    private Tool[] workerTools;

    public Worker(int workerNumber, Tool[] workerTools) {
        this.workerNumber = workerNumber;
        this.workerTools = workerTools;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Sort tools by tool number to avoid deadlock
                Arrays.sort(workerTools, Comparator.comparingInt(t -> t.toolNum));

                // Try to acquire all tools in order
                for (Tool tool : workerTools) {
                    tool.acquire();
                    Actions.tryToTakeTool(workerNumber, tool.toolNum);
                    Actions.takeToolSuccessful(workerNumber, tool.toolNum);
                }

                // Perform the work
                Actions.work(workerNumber);

            } finally {
                // Always release the tools in the same order they were acquired
                for (Tool tool : workerTools) {
                    tool.release();
                    Actions.putTool(workerNumber, tool.toolNum);
                }
            }
        }
    }
}