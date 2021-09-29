package shared_variables;

public class Process {

    private int PID = 0 + (int)(Math.random() * ((99999 - 0) + 1));
    private int data;

    public Process(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public int getPID() {
        return PID;
    }
}