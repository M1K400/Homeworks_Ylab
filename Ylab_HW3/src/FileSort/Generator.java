package FileSort;

import java.io.*;
import java.util.Random;

public class Generator {

    public File generate(String name, int count) throws IOException {
        Random random = new Random();
        File file = new File(name);
        try (PrintWriter pw = new PrintWriter(file)) {

            for (int i = 0; i < count; i++) {
                pw.println(random.nextLong());
            }
            pw.flush();

        }
        return file;
    }


}
