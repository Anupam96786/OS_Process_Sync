package shared_variables;

public class Process {

    private int PID = 1000 + (int)(Math.random() * ((99999 - 1000) + 1));
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