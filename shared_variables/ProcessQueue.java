package shared_variables;

import java.util.Queue;

public class ProcessQueue {
    // public static final int maxSize = Data.getMaxSize();
    public static final int maxSize = 5;

    public static boolean add(Process p) {
        Queue<Process> pq = Data.getProcessQueue();
        if (pq.size() >= maxSize) {
            return false;
        } else {
            pq.add(p);
            Data.storeProcessQueue(pq);
            return true;
        }
    }

    public static Process poll() {
        Queue<Process> pq = Data.getProcessQueue();
        Process p = pq.poll();
        Data.storeProcessQueue(pq);
        return p;
    }

    public static boolean isEmpty() {
        Queue<Process> pq = Data.getProcessQueue();
        return pq.isEmpty();
    }

    public static boolean isFull() {
        Queue<Process> pq = Data.getProcessQueue();
        return pq.size() >= maxSize;
    }
}
