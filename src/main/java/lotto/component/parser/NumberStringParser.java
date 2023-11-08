package lotto.component.parser;

import java.util.ArrayList;
import java.util.List;

public class NumberStringParser {

    public static List<Integer> parseToIntegers(String input) throws IllegalArgumentException {
        List<String> numbers;
        List<Integer> numbersParsed;
        try {
            numbers = List.of(input.split(","));
            numbersParsed = new ArrayList<>();
            for (String number : numbers) {
                numbersParsed.add(Integer.parseInt(number));
            }
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] numbers must be comma separated");
            throw new IllegalArgumentException("[ERROR] numbers must be comma separated");
        }
        return numbersParsed;
    }

    public static Integer parseToInteger(String input) throws IllegalArgumentException {
        Integer numberParsed;
        try {
            numberParsed = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] number must be integer");
            throw new IllegalArgumentException("[ERROR] number must be integer");
        }
        return numberParsed;
    }

}
