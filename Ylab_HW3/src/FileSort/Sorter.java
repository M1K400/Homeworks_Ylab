package FileSort;



import java.io.*;
import java.util.*;

public class Sorter {

    //Количество файлов которые я буду использовать
    private int countFileProg = 10;

    //Размер массива в каждом файле прогона.
    private int sizeFileProg = 10;


    //Файл для чтения всех этих файлов
    private ArrayList<Scanner> files = new ArrayList<>();

    //
    private ArrayList<Long> minHeap = new ArrayList<>();


    //Вот здесь начинается самая мякотка
    public File sortFile(File dataFile) throws IOException {
        File res = new File("./Ylab_HW3/src/FileSort/files/resDate.txt");
        try (FileInputStream fileInputStream = new FileInputStream(dataFile);
             PrintWriter pw = new PrintWriter(res);
            ) {

            Scanner scanner = new Scanner(fileInputStream);

            //Читаем data.txt и распределяю данные по прогонам.
            readFileData(scanner);
            //Прочитываем прогоны и закидываем данные в результирующий файл
            writeSortDateToResFile(pw);
        }



        return res;
    }

    private void writeSortDateToResFile(PrintWriter pw){
        //Количество пройденных прогонов ( В случай если кто то закончил чтение своего файла суммируем)
        int count = 0;
        int countVa = 0;
        while (count != countFileProg){
            //Находим минимальное число и его индекс
            long min = minHeap.stream().min(Long::compare).get();
            int index = minHeap.indexOf(min);
            //Проверяем можно ли дальше вытащить данные из файла иначе данный файл заканчивает свою работу
            boolean isHaveNextLine = files.get(index).hasNextLine();
            if (isHaveNextLine) {
                //Закидываем данные в результирующий файл
                String valueFromFile = files.get(index).nextLine();
                if (!valueFromFile.isEmpty()) {
                    minHeap.set(index, Long.parseLong(valueFromFile));
                    pw.println(min);
                }

            } else {
                count++;
                files.get(index).close();
                minHeap.remove(index);
                files.remove(index);
            }
            countVa++;
        }

    }


    /**
     * Данная функция предназначена для чтения data.txt и распределить эти данные в прогоны
     * @param scanner
     * @throws IOException
     */
    private void readFileData(Scanner scanner) throws IOException {
        //Вытаскиваем данные под размер массива в каждый файл.
        for (int i = 0; i < countFileProg; i++){
            long[] src = new long[sizeFileProg];
            for (int j = 0; j < src.length;j++){
                src[j] = Long.parseLong(scanner.nextLine());
            }
            //Сортируем это всё и записываем всё в файлик
            src = mergeSort(src);
            createFileAndWrite("./Ylab_HW3/src/FileSort/files/"+i,src);
            //Закидываем минимальное число из сортированного массива и закидываем в список
            minHeap.add(src[0]);
        }
    }



    //Запись данных в файл прогона и подготовка к чтению этих данных из файлов.
    private void createFileAndWrite(String path,long[] src) throws IOException {
        File file = new File(path);
        try(PrintWriter pw = new PrintWriter(file)) {
            for (int i = 0; i < src.length;i++){
                pw.println(src[i]);
            }
        }
        files.add(new Scanner(new FileInputStream(file)));
    }


    //Дальше идёт сортировка слиянием, а точнее деление массива на куски для сортировки
    public long[] mergeSort(long[] array){

        //временный массив чтобы можно было менять ссылки.
        long[] tmp;
        //Массив источник
        long[] currentSrc = array;
        //Результирующий массив после слияния
        long[] currentDest = new long[array.length];

        //Сначала идёт размер массив 1
        int size = 1;
        //Если размер меньше длины массив продолжаем работу.
        while (size < array.length) {


            for (int i = 0; i < array.length; i += 2 * size) {
                merge(currentSrc, i, currentSrc, i + size, currentDest, i, size);
            }

            tmp = currentSrc;
            currentSrc = currentDest;
            currentDest = tmp;

            //Увеличиваем размер массива
            size = size * 2;

        }
        return currentSrc;
    }

    //Слияние массивов в один
    public void merge(long[] src1, int src1Start, long[] src2, int src2Start, long[] dest, int destStart, int size){

        //индекс текущего элемента 1 массива
        int index1 = src1Start;
        //индекс текущего элемента 2 массива
        int index2 = src2Start;

        //Вычисляем концы под массивов
        int src1End = Math.min(src1Start + size, src1.length);
        int src2End = Math.min(src2Start + size, src2.length);

        //Обработка нужна для случая, когда не с чем сливать остаток массива.
        if (src1Start + size > src1.length) {
            for (int i = src1Start; i < src1End; i++) {
                dest[i] = src1[i];
            }
            return;
        }


        //Вычисляю сколько итераций надо сделать чтобы соединить два массива.
        int iterationCount = src1End - src1Start + src2End - src2Start;

        for (int i = destStart; i < destStart + iterationCount; i++) {
            //Если индекс текущего элемента не превышен и
            //если элемент первого массива меньше второго или индекс текущего второго массива дошёл до конца
            //то результат берём из первого массива иначе со второго.
            if (index1 < src1End && (index2 >= src2End || src1[index1] < src2[index2])) {
                dest[i] = src1[index1];
                index1++;
            } else {
                dest[i] = src2[index2];
                index2++;
            }

        }

    }


}
