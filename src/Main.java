import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        int count = 0;


        Map<Integer, String> words = new HashMap<>();
        List<String> azerbaijanWords = new ArrayList<>();
        List<String> englishWords = new ArrayList<>();

        Random random = new Random();



        BufferedReader bufferedReader = new BufferedReader
                (new FileReader("lib/Words.txt"));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            count++;
            words.put(count, line);
            String[] parts = line.split(", ");
            String english = parts[0];
            String azerbaijan = parts[1];
            azerbaijanWords.add(azerbaijan);
            englishWords.add(english);
        }



        Scanner scanner = new Scanner(System.in);
        System.out.println("Should the question be asked in English or in Azerbaijani language?\n " +
                "\n1)Azerbaijan" +
                "\n2)English");
        System.out.print("Answer: ");
        int choose = scanner.nextInt();
        System.out.println("Staring....\n");


        if (choose == 1) {

            for (int i = 0; i < 5; i++) {
                int randomNumber = random.nextInt(0, count);
                System.out.print(azerbaijanWords.get(randomNumber) + ": ");
                String answer = scanner.next();

                if (englishWords.get(randomNumber).equals(answer)) {
                    System.out.println("+");
                } else {
                    System.out.println("-");
                }
            }


        } else if (choose == 2) {
            for (int i = 0; i < 5; i++) {
                int randomNumber = random.nextInt(0, count);
                System.out.print(englishWords.get(randomNumber) + ": ");
                String answer = scanner.next();

                boolean check = azerbaijanWords.get(randomNumber).equals(answer);

                if (check) {
                    System.out.println("+");
                } else {
                    System.out.println("-");
                }
            }

        } else {
            System.out.println("Wrong language");
        }


    }
}

