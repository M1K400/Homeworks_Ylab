package FileSort;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Validator {

    private File file;
    public Validator(File file) {
        this.file = file;
    }
    public boolean isSorted() {
        int index = 0;
        try (Scanner scanner = new Scanner(new FileInputStream(file))) {
            long prev = Long.MIN_VALUE;
            while (scanner.hasNextLong()) {
                long current = scanner.nextLong();
                if (current < prev) {
                    //Чтобы я мог понимать на каком индексе он его выкидывает.
                    System.out.println("Индекс: " + index);
                    return false;
                } else {
                    prev = current;
                }
                index++;
            }
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
