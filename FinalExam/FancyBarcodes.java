package FinalExam;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class FancyBarcodes {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int n = Integer.parseInt(scanner.nextLine()); //entering heroes

            LinkedHashMap<String, List<Integer>> heroes = new LinkedHashMap<>(); // holding hero names, (HP, MP)

            for (int i = 0; i <n ; i++) {
                String input = scanner.nextLine();
                String tokens[] = input.split(" ");
                String heroName = tokens[0];
                int hitPoints = Integer.parseInt(tokens[1]);
                int manaPoints = Integer.parseInt(tokens[2]);

                List<Integer> current = new ArrayList<>();
                current.add(hitPoints);
                current.add(manaPoints);

                heroes.put(heroName,current);
            }

            while (true){
                String input = scanner.nextLine();
                if (input.equals("End")){
                    break;
                }
                String[] tokens = input.split(" - ");
                String cmd = tokens[0];
                String heroName = tokens[1];

                switch (cmd){

                    case"CastSpell":
                        int manaPointsNeed = Integer.parseInt(tokens[2]);
                        String spellName = tokens[3];

                        List<Integer> data = heroes.get(heroName);
                        int currentMana = data.get(1);
                        if (currentMana >= manaPointsNeed){
                            currentMana -= manaPointsNeed;
                            heroes.get(heroName).set(1, currentMana);
                            System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, currentMana);
                        }else{
                            System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                        }
                        break;

                    case"TakeDamage":
                        int damage = Integer.parseInt(tokens[2]);
                        String attacker = tokens[3];

                        List<Integer> data2 =heroes.get(heroName);
                        int currentHp = data2.get(0);
                        if (currentHp >= 0){
                            currentHp -= damage;
                            heroes.get(heroName).set(0, currentHp);
                            if (currentHp<=0){
                                heroes.remove(heroName);
                                System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                            }else{
                                System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damage, attacker, currentHp);
                            }
                        }
                        break;

                    case"Recharge":
                        int amount = Integer.parseInt(tokens[2]);
                        List<Integer> data3 = heroes.get(heroName);
                        int currentMP = data3.get(1);

                        if (currentMP+ amount > 200){
                            amount = Math.abs(100 - currentMP);
                        }
                        heroes.get(heroName).set(1, currentMP + amount);
                        System.out.printf("%s recharged for %d MP!%n", heroName, amount);
                        break;

                    case"Heal":
                        int amount2 = Integer.parseInt(tokens[2]);
                        List<Integer> data4 = heroes.get(heroName);
                        int currentHP = data4.get(0);

                        if (currentHP + amount2> 100){
                            amount2 = Math.abs(100 - currentHP);
                        }
                        heroes.get(heroName).set(0, currentHP + amount2);
                        System.out.printf("%s healed for %d HP!%n", heroName, amount2);
                        break;
                }
            }
            heroes.forEach((key, value) -> System.out.printf("%s%n  HP: %d%n  MP: %d%n", key, value.get(0), value.get(1)));
        }
    }

