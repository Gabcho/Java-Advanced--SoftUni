package FinalExam;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ThePianist {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int number = Integer.parseInt(scanner.nextLine());
            Map<String, Map<String, String>> piecesMap = new LinkedHashMap<>();

            for (int i = 0; i < number; i++) {
                String[] currentPiece = scanner.nextLine().split("\\|");

                String pieceName = currentPiece[0];
                String composer = currentPiece[1];
                String key = currentPiece[2];

                piecesMap.putIfAbsent(pieceName, new LinkedHashMap<>());
                piecesMap.get(pieceName).put(composer, key);


            }

            String line = scanner.nextLine();

            while (!line.equals("Stop")) {
                String[] commandLine = line.split("\\|");
                String currentCommand = commandLine[0];

                String pieceName = commandLine[1];
                Map<String, String> checkPiece = piecesMap.get(pieceName);
                switch (currentCommand) {
                    case "Add":
                        String composer = commandLine[2];
                        String key = commandLine[3];

                        if (checkPiece == null) {
                            piecesMap.put(pieceName, new LinkedHashMap<>());
                            piecesMap.get(pieceName).put(composer, key);
                            System.out.printf("%s by %s in %s added to the collection!%n", pieceName, composer, key);
                        } else {
                            System.out.println(pieceName + " is already in the collection!");
                        }
                        break;
                    case "Remove":
                        if (checkPiece == null) {
                            System.out.println("Invalid operation! " + pieceName + " does not exist in the collection.");
                        } else {
                            piecesMap.remove(pieceName);
                            System.out.println("Successfully removed " + pieceName + "!");
                        }

                        break;
                    case "ChangeKey":
                        String newKey = commandLine[2];

                        if (checkPiece == null) {
                            System.out.println("Invalid operation! " + pieceName + " does not exist in the collection.");
                        } else {
                            String getValueToString = checkPiece.toString();
                            String getComposer = getValueToString.substring(0, getValueToString.indexOf("=")).replaceAll("[^A-z]", "");

                            piecesMap.get(pieceName).put(getComposer, newKey);

                            System.out.printf("Changed the key of %s to %s!%n", pieceName, newKey);
                        }
                        break;


                }


                line = scanner.nextLine();
            }


            for (Map.Entry<String, Map<String, String>> entry : piecesMap.entrySet()) {
                System.out.printf("%s -> ", entry.getKey());

                for (Map.Entry<String, String> value : entry.getValue().entrySet()) {

                    System.out.printf("Composer: %s, Key: %s", value.getKey(), value.getValue());
                }

                System.out.println();
            }


        }

    }


