package OrgStructure.repository;

import java.io.File;
import java.io.IOException;

public interface OrgStructureParser {
    /**
     *
     * Метод parseStructure считывает данные из файла и возвращает ссылку на босса.
     * Считать, что такой сотрудник в файле ровно один.
     *
     * @param csvFile
     * @return
     * @throws IOException
     */
    Employee parseStructure(File csvFile) throws IOException;

}
