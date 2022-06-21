package FinalExam;

import java.util.Scanner;
import java.util.regex.Pattern;

public class SecretChat {

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            StringBuilder sb = new StringBuilder(scanner.nextLine());

            String input = scanner.nextLine();

            while (!input.equals("Reveal")) {

                String[] information = input.split(":\\|:");
                String command = information[0];

                switch (command) {
                    case "InsertSpace":
                        int index = Integer.parseInt(information[1]);
                        sb.insert(index, " ");

                        System.out.println(sb);
                        break;
                    case "Reverse":
//                    StringBuilder givenString = new StringBuilder(information[1]);
//                    if (sb.toString().contains(givenString.toString())) {
//                        sb.replace(0, sb.length(), sb.toString().replace(givenString, ""));
//                        sb.append(givenString.reverse());
//                        System.out.println(sb);
//                    } else {
//                        System.out.println("error");
//                    }

                        String replace = information[1];
                        String message = sb.toString();

                        if (!message.contains(information[1])) {
                            System.out.println("error");
                        } else {
                            String toReplace = new StringBuilder(replace).reverse().toString();
                            message = message.replaceFirst(Pattern.quote(replace), "") + toReplace;
                            System.out.println(message);
                            sb = new StringBuilder(message);
                        }
                        break;
                    case "ChangeAll":
                        String oldString = information[1];
                        String newsString = information[2];
                        sb.replace(0, sb.length(), sb.toString().replace(oldString, newsString));
                        System.out.println(sb);
                        break;
                }
                input = scanner.nextLine();
            }
            System.out.printf("You have a new text message: %s", sb);

        }
    }

