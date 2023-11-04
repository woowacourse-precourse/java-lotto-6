package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lotto.Validator.Validator;

public class Parser {
    private static final String DELIMITER = ",";

    private static List<String> parseStringSplitComma(String input) {
        List<String> parseString = Arrays.asList(input.split(DELIMITER));
        return parseString;
    }

    public static int parsePurchaseAmount(String input) {
        int purchaseAmount = Validator.validateParseInt(input);
        return purchaseAmount;
    }

    public static List<String> parseIntToString(List<Integer> numbers) {
        List<String> strings = new ArrayList<>();
        for (int number : numbers) {
            strings.add(Integer.toString(number));
        }
        return strings;
    }

    private static List<Integer> parseStringToInteger(List<String> strings) {
        List<Integer> numbers = new ArrayList<>();
        for (String string : strings) {
            numbers.add(Validator.validateParseInt(string));
        }
        return numbers;
    }

    public static List<Integer> parseWinningNumbers(String input) {
        return parseStringToInteger(parseStringSplitComma(input));
    }
}
