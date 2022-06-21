package FinalExam;

import java.util.Scanner;

public class WorldTour {

    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            StringBuilder text = new StringBuilder(scanner.nextLine());

            String line = scanner.nextLine();
            while (!line.equals("Travel")) {
                String[] tokens = line.split(":");

                String command = tokens[0];

                switch (command) {

                    case "Add Stop":
                        int index = Integer.parseInt(tokens[1]);
                        String toInsert = tokens[2];

                        if (index < 0 || index > text.length()) {
                            line = scanner.nextLine();
                            continue;
                        } else {
                            text.insert(index, toInsert);
                        }
                        break;
                    case "Remove Stop":
                        int startIndex = Integer.parseInt(tokens[1]);
                        int endIndex = Integer.parseInt(tokens[2]);


                        if ((startIndex > -1 && startIndex < text.length()) && (endIndex > -1 && endIndex < text.length())) {
                            text.delete(startIndex, endIndex + 1);
                        }
//                    if ((startIndex < 0 || startIndex > text.length()) || (endIndex < 0 || endIndex > text.length())) {
//                        line = scanner.nextLine();
//                        continue;
//                    } else {
//                        text.delete(startIndex, endIndex + 1);
//                    }
                        break;
                    case "Switch":
                        String oldString = tokens[1];
                        String newString = tokens[2];
                        if (text.toString().contains(oldString)) {
                            text = new StringBuilder(text.toString().replace(oldString, newString));
                        }
                        break;
                }
                System.out.println(text);
                line = scanner.nextLine();
            }
            System.out.printf("Ready for world tour! Planned stops: %s", text);
        }
    }

