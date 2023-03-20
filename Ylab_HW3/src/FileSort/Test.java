package FileSort;

import java.io.File;
import java.io.IOException;

public class Test {


    public static void main(String[] args) {
        try {

            File dataFile = new Generator().generate("./Ylab_HW3/src/FileSort/files/data.txt",  100);
            System.out.println(new Validator(dataFile).isSorted()); // false
            File sortedFile = new Sorter().sortFile(dataFile);
            System.out.println(new Validator(sortedFile).isSorted()); // true

        } catch (IOException | RuntimeException ex){
            System.out.println("Произошла ошибка при работе программы: "  + ex.getMessage());
        }
    }

}
