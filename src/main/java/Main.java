import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String filePathTask_1 = "src\\main\\resources\\Strings.txt";
        String filePathTask_2 = "src\\main\\resources\\Studies.txt";


//      1.  Даны две строки. Вывести в консоль все слова из первой строки, которые отсутствуют во второй.

        try {
            PrintWriter writer = new PrintWriter(new FileWriter("results.txt"));
            writer.println("Task 4.1: ");
            writer.println("Слова, отсутсвующие во второй строке: ");
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
                    writer.println(firstStringArr[i]);
                }
            }

//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        writer.println(" ");

//        2. В текстовый файл построчно записаны фамилия и имя учащихся класса и его оценка за контрольную.
//           Вывести на экран всех учащихся, чья оценка меньше 3 баллов и посчитать средний балл по классу.
            writer.println("Task 4.2: ");
//        try {
            List<String> readStudies = Files.readAllLines(Paths.get(filePathTask_2));
            int sum = 0;
            int count = readStudies.size();
            writer.println("Ученики с оценкой ниже 3:");
            for (String studies : readStudies) {
                String[] splitArr = studies.split(" ");
                int mark = Integer.parseInt(splitArr[2]);
                if (mark < 3) {
                    writer.println(String.format("%s %s", splitArr[0], splitArr[1]));
                }
                sum += mark;
            }
            writer.println("\n" + "Средний балл по классу: ");
            double avg = sum / (1.0d * count);
            writer.println(String.format("%.2f", avg));
            writer.flush();
//            System.out.println("\n" + String.format("%.2f", avg));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
