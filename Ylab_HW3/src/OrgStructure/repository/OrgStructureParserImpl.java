package OrgStructure.repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class OrgStructureParserImpl implements OrgStructureParser {

    //Сотрудники которые не являются главными боссами
    private ArrayList<Employee> emp = new ArrayList<>();

    //Очередь сотрудников для того чтобы обновить им bossId и узнать есть ли у них помощники на основе их id
    private Queue<Employee> treeMapQueueEmployee = new LinkedList<>();

    private Employee main;

    List<Employee> getEmployees(Long bossId) {
        //Если будет такая ситуация что пользователей будет больше 100 воспользоваться распараллеливанием потоков.
        //чтобы можно было быстрее сделать поиск.
        if (emp.size() > 100){
            return emp.stream().parallel().filter(employee -> employee.getBossId().equals(bossId)).collect(Collectors.toList());
        } else {
            return emp.stream().filter(employee -> employee.getBossId().equals(bossId)).collect(Collectors.toList());
        }
    }

    @Override
    //Читаем файлик
    public Employee parseStructure(File csvFile) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(csvFile)){
            Scanner scanner = new Scanner(fileInputStream);
            while (scanner.hasNextLine()){
                //Делим это с помощью split
                String[] res = scanner.nextLine().split(";");
                //Если получается что там не данные, а атрибуты то можно пропустить.
                if (!res[0].equals("id")){
                    //Находим главного (того у кого boss_id = null)
                    // иначе кидаем его в список сотрудников у которых есть начальник.
                    if (res[1].isEmpty()){
                        main = new Employee(Long.parseLong(res[0]),res[2],res[3]);
                    } else {
                        Employee notMainEmp = new Employee(Long.parseLong(res[0]), Long.parseLong(res[1]),
                                res[2], res[3]);
                        emp.add(notMainEmp);
                    }
                }

            }
            //После этого начинаем делать связь между главным и подчинёнными.
            addSubordinate();
            return main;
        } catch (IOException | RuntimeException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    //Решил сделать по принципу алгоритма поиск в ширину
    public void addSubordinate(){
        //Кидаем главного
        treeMapQueueEmployee.add(main);
        while (!treeMapQueueEmployee.isEmpty()){
            Employee e = treeMapQueueEmployee.remove();
            //Находим тех сотрудников у которых boss_id совпадает.
            List<Employee> findEmp = getEmployees(e.getId());
            for (int i = 0; i < findEmp.size();i++){
                //Даём ссылочку и закидываем их в очередь.
                findEmp.get(i).setBoss(e);
                treeMapQueueEmployee.add(findEmp.get(i));
            }
            //Кидаем их в список прямых подчинённых.
            e.getSubordinate().addAll(findEmp);
        }
    }



}
