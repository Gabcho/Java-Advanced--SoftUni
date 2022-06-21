package FinalExam;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int totalCals = 0;

        String regex = "(?<symbols>[#\\|])(?<name>[A-za-z\\s]+)(\\1)(?<date>[0-9]{2}[\\/][0-9]{2}[\\/][0-9]{2})(\\1)(?<calories>[\\d]{1,5})(\\1)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        Map<String, String> foodDate = new LinkedHashMap<>();
        Map<String, Integer> calories = new LinkedHashMap<>();

        List<String> products = new ArrayList<>();

        while(matcher.find()){
            String product = matcher.group("name");
            String expDate = matcher.group("date");
            int cals = Integer.parseInt(matcher.group("calories"));

            foodDate.putIfAbsent(product,expDate);
            calories.putIfAbsent(product, cals);
            totalCals += cals;
            products.add(String.format("Item: %s, Best before: %s, Nutrition: %d", product, expDate, cals));
        }

        System.out.printf("You have food to last you for: %d days!%n", totalCals/2000);

        products.forEach(System.out::println);
    }
}