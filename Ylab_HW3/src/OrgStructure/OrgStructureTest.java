package OrgStructure;

import OrgStructure.repository.OrgStructureParserImpl;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class OrgStructureTest {

    private final static OrgStructureParserImpl orgStructureParserImpl = new OrgStructureParserImpl();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Напишите названия файла (Например: test.csv): " );
            String fileName = scanner.nextLine();
            File file = new File("./Ylab_HW3/src/OrgStructure/files/" + fileName);

            System.out.println("Ссылка на босса: " + orgStructureParserImpl.parseStructure(file));

        } catch (IOException | RuntimeException exception) {
            System.out.println("Произошла ошибка при работе программы: "  + exception.getMessage());
        }
    }

}
