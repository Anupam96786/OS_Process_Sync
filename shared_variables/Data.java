package shared_variables;

import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.Queue;
import java.util.prefs.Preferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Data {
    private static Preferences pref = Preferences.userRoot();

    static {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                if (!producerIsOpen() && !consumerIsOpen()) {
                    clearData();
                    System.out.println("Data cleared");
                }
            }
        });
    }

    static void storeProcessQueue(Queue<Process> p) {
        pref.put("processQueue", new Gson().toJson(p));
    }

    static Queue<Process> getProcessQueue() {
        Queue<Process> q;
        Type type = new TypeToken<Queue<Process>>(){}.getType();
        q = new Gson().fromJson(pref.get("processQueue", ""), type);
        if (q == null) {
            q = new LinkedList<>();
        }
        return q;
    }

    public static void openProducer() {
        pref.put("producer", Boolean.toString(true));
    }

    public static void closeProducer() {
        pref.put("producer", Boolean.toString(false));
    }

    private static boolean producerIsOpen() {
        return Boolean.parseBoolean(pref.get("producer", "0"));
    }

    public static void openConsumer() {
        pref.put("consumer", Boolean.toString(true));
    }

    public static void closeConsumer() {
        pref.put("consumer", Boolean.toString(false));
    }

    private static boolean consumerIsOpen() {
        return Boolean.parseBoolean(pref.get("consumer", "0"));
    }

    static void clearData() {
        pref.remove("maxSize");
        pref.remove("processQueue");
        pref.remove("producer");
        pref.remove("consumer");
    }
}
