package FinalExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TheImitationGame {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            String encryptedMessage = scanner.nextLine();

            String input = scanner.nextLine();
            while (!input.equals("Decode")) {
                List<String> commandLine = Arrays.stream(input.split("\\|")).
                        collect(Collectors.toList());


                switch (commandLine.get(0)) {
                    case "Move":
                        int indexToBack = Integer.parseInt(commandLine.get(1));

                        encryptedMessage = move(encryptedMessage, indexToBack).toString();

                        break;
                    case "Insert":
                        int index = Integer.parseInt(commandLine.get(1));
                        String value = commandLine.get(2);

                        encryptedMessage = insert(encryptedMessage, index, value).toString();


                        break;
                    case "ChangeAll":
                        String currentLetter = commandLine.get(1);
                        String replaceLetter = commandLine.get(2);

                        encryptedMessage = encryptedMessage.replace(currentLetter, replaceLetter);
                        break;

                }


                input = scanner.nextLine();
            }


            System.out.print("The decrypted message is: " + encryptedMessage);

        }

        public static StringBuilder move(String message, int n) {
            String firstLetters = message.substring(0, n);
            String toEnd = message.substring(n);

            return new StringBuilder(toEnd + firstLetters);
        }

        public static StringBuilder insert(String message, int index, String value) {
            String first = message.substring(0, index);
            String end = message.substring(index);

            return new StringBuilder(first + value + end);
        }

    }


