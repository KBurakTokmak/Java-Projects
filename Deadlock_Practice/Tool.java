import java.util.concurrent.locks.ReentrantLock;

public class Tool {
    private final ReentrantLock lock = new ReentrantLock();
    public final int toolNum;

    Tool(int toolNum){
        this.toolNum = toolNum;
    }
    public void acquire() {
        lock.lock();
    }

    public void release() {
        lock.unlock();
    }
}