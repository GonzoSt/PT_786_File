import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String filePathTask_1 = "src\\main\\resources\\Strings.txt";
        String filePathTask_2 = "src\\main\\resources\\Studies.txt";


//      1.  Даны две строки. Вывести в консоль все слова из первой строки, которые отсутствуют во второй.
        System.out.println("Task 4.1: ");
        try {
            String firstLine = Files.readAllLines(Paths.get(filePathTask_1)).get(0);
            String secondLine = Files.readAllLines(Paths.get(filePathTask_1)).get(1);

            String[] firstStringArr = firstLine.split(" ");
            String[] secondStringArr = secondLine.split(" ");


            for (int i = 0; i < firstStringArr.length; i++) {
                boolean isExistInSecondRow = false;
                for (int j = 0; j < secondStringArr.length; j++) {
                    if (firstStringArr[i].equals(secondStringArr[j])) {
                        isExistInSecondRow = true;
                        break;
                    }
                }
                if (!isExistInSecondRow) {
                    System.out.println(firstStringArr[i]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(" ");

//        2. В текстовый файл построчно записаны фамилия и имя учащихся класса и его оценка за контрольную.
//           Вывести на экран всех учащихся, чья оценка меньше 3 баллов и посчитать средний балл по классу.
        System.out.println("Task 4.2: ");
        try {
            List<String> readStudies = Files.readAllLines(Paths.get(filePathTask_2));
//            for (String str : readStudies) {
//                System.out.println(str);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
