package lotto;

import java.util.ArrayList;
import java.util.List;

import lotto.Validator.Validator;

public class Parser {
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
}
