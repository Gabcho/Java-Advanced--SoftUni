package StacksAndQueues;

import java.util.*;
import java.util.stream.Collectors;

public class Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> steel = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> carbon = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(carbon::push);

        int swordCounter = 0;
        int gladiusCount = 0;
        int shamshirCount = 0;
        int katanaCount = 0;
        int sabreCount = 0;
        while (!(steel.size() == 0 || carbon.size() == 0)) {
            int mix = steel.peek() + carbon.peek();

            switch (mix) {
                case 70:
                    swordCounter++;
                    gladiusCount++;
                    steel.poll();
                    carbon.pop();
                    break;
                case 80:
                    swordCounter++;
                    shamshirCount++;
                    steel.poll();
                    carbon.pop();
                    break;
                case 90:
                    swordCounter++;
                    katanaCount++;
                    steel.poll();
                    carbon.pop();
                    break;
                case 110:
                    swordCounter++;
                    sabreCount++;
                    steel.poll();
                    carbon.pop();
                    break;
                default:
                    steel.poll();
                    int carbonPlus5 = carbon.pop() + 5;
                    carbon.add(carbonPlus5);
                    for (int i = 0; i < carbon.size() - 1; i++) {
                        int t = carbon.pop();
                        carbon.add(t);
                    }
            }
        }

        if (swordCounter > 0) {
            System.out.println("You have forged " + swordCounter + " swords.");
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }

        if (steel.size() > 0) {
            System.out.println("Steel left: ");
            for (Integer s : steel) {
                System.out.println(s);
            }
        } else {
            System.out.println("Steel left: none");
        }

        List<String> list = new ArrayList<>();

        if (carbon.size() > 0) {
            System.out.print("Carbon left:");
            for (Integer c : carbon) {
                list.add(c.toString());
            }
            System.out.print(" " + list.toString().replaceAll("[\\[\\]]", ""));
            System.out.println();
        } else {
            System.out.println("Carbon left: none");
        }

        if (sabreCount > 0) {
            System.out.println("Sabre: " + sabreCount);
        }
        if (katanaCount > 0) {
            System.out.println("Katana: " + katanaCount);
        }
        if (shamshirCount > 0) {
            System.out.println("Shamshir: " + shamshirCount);
        }
        if (gladiusCount > 0) {
            System.out.println("Gladius: " + gladiusCount);
        }

    }
}
