package Model;

import java.io.IOException;

public class Shutdown {
    public static boolean Shutdown(int minutes) {
        Runtime runtime = Runtime.getRuntime();
        boolean shutdown = false;
        int seconds = 0;

        if(minutes > 0) {
            shutdown = true;
            seconds = minutes * 60;
        }

        try {
            Process process = runtime.exec(new String[]{"shutdown", "-s", "-t", String.valueOf(seconds)});
        } catch(IOException e) {
            e.printStackTrace();
        }

        return shutdown;
    }

    public static void Cancel() {
        Runtime runtime = Runtime.getRuntime();
        try {
            Process process = runtime.exec(new String[]{"shutdown", "-a"});
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
