import java.util.concurrent.locks.ReentrantLock;

public class ToolManager {
    private final ReentrantLock[] toolLocks;

    public ToolManager(int numTools) {
        toolLocks = new ReentrantLock[numTools];
        for (int i = 0; i < numTools; i++) {
            toolLocks[i] = new ReentrantLock();
        }
    }

    public boolean tryAcquireTools(int[] requestedTools) {
        // Try to acquire all locks
        for (int toolId : requestedTools) {
            if (!toolLocks[toolId].tryLock()) {
                // If a lock is not available, release all and return false
                releaseTools(requestedTools);
                return false;
            }
        }
        return true;
    }

    public void releaseTools(int[] tools) {
        for (int toolId : tools) {
            if (toolLocks[toolId].isHeldByCurrentThread()) {
                toolLocks[toolId].unlock();
            }
        }
    }
}