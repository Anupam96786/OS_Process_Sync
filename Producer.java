import java.util.Scanner;

import shared_variables.Data;
import shared_variables.ProcessQueue;
import shared_variables.Process;

public class Producer {
    public static void main(String[] args) {
        Data.openProducer();
        Scanner sc = new Scanner(System.in);

        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                sc.close();
                Data.closeProducer();
            }
        });

        while (true) {
            if (ProcessQueue.isFull()) {
                while (ProcessQueue.isFull()) {
                }
            } else {
                try {
                    System.out.print("Enter Data: ");
                    Process process = new Process(sc.nextInt());
                    System.out.println("Process created.\tPID: " + process.getPID() + "\tData: " + process.getData() + "\n");
                    ProcessQueue.add(process);
                } catch (Exception e) {
                    System.exit(-1);
                }
            }
        }
    }
}
