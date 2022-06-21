package FinalExam;

import java.util.*;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> rarityOfPlantsMap = new LinkedHashMap<>();

        Map<String, List<Integer>> ratingOfPlantsMap = new LinkedHashMap<>();


        for (int i = 0; i < number; i++) {
            String[] currentLine = scanner.nextLine().split("<->");
            rarityOfPlantsMap.putIfAbsent(currentLine[0], 0);
            rarityOfPlantsMap.put(currentLine[0], Integer.parseInt(currentLine[1]));

            ratingOfPlantsMap.putIfAbsent(currentLine[0], new ArrayList<>());
        }


        String line = scanner.nextLine();

        while (!line.equals("Exhibition")) {
            line = line.replaceAll("[^A-z0-9\\s]", "");
            String[] commandLine = line.split("\\s+");

            List<Integer> checkRating = ratingOfPlantsMap.get(commandLine[1]);
            switch (commandLine[0]) {
                case "Rate":
                    if (checkRating == null) {
                        System.out.println("error");
                    } else {
                        ratingOfPlantsMap.get(commandLine[1]).add(Integer.parseInt(commandLine[2]));
                    }
                    break;
                case "Update":
                    String plant = commandLine[1];
                    Integer checkPlant = rarityOfPlantsMap.get(plant);
                    if (checkPlant == null) {
                        System.out.println("error");
                    } else {
                        int rarity = Integer.parseInt(commandLine[2]);
                        rarityOfPlantsMap.put(plant, rarity);
                    }
                    break;
                case "Reset":
                    if (checkRating == null) {
                        System.out.println("error");
                    } else {
                        ratingOfPlantsMap.get(commandLine[1]).removeAll(checkRating);
                    }
                    break;

            }


            line = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");


        for (Map.Entry<String, Integer> entry : rarityOfPlantsMap.entrySet()) {
            String currentPlant = entry.getKey();
            List<Integer> listValue = ratingOfPlantsMap.get(currentPlant);
            double average = 0.0;
            if (!listValue.isEmpty()) {
                average = listValue.stream().mapToDouble(r -> r).average().getAsDouble();
            }


            System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", entry.getKey(), entry.getValue(), average);
        }


    }
}


