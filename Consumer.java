import shared_variables.Data;
import shared_variables.Process;
import shared_variables.ProcessQueue;

public class Consumer {
    public static void main(String[] args) {
        Data.openConsumer();

        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                Data.closeConsumer();
            }
        });

        while (true) {
            if (ProcessQueue.isEmpty()) {
                try {
                    while (ProcessQueue.isEmpty()) {
                    }
                } catch (Exception e) {
                    System.exit(-1);
                }
            } else {
                try {
                    Thread.sleep(5000);
                    Process process = ProcessQueue.poll();
                    System.out.println("PID " + process.getPID() + "\tData: " + process.getData());
                } catch (Exception e) {
                    System.exit(-1);
                }
            }
        }
    }
}
