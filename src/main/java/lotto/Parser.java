package lotto;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lotto.Validator.Validator;

public class Parser {
    private static final String DELIMITER = ",";

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

    public static List<Integer> parseWinningNumbers(String input) {
        Validator.validateLastComma(input);
        return parseStringToInteger(parseStringSplitComma(input));
    }

    private static List<Integer> parseStringToInteger(List<String> strings) {
        List<Integer> numbers = new ArrayList<>();
        for (String string : strings) {
            numbers.add(Validator.validateParseInt(string));
        }
        return numbers;
    }
    
    private static List<String> parseStringSplitComma(String input) {
        List<String> parseString = Arrays.asList(input.split(DELIMITER));
        return parseString;
    }

    public static int parseBonusNumber(String input) {
        int bonusNumber = Validator.validateParseInt(input);
        return bonusNumber;
    }

    public static String parseProfitRateFormat(double profitRate) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.0");
        return decimalFormat.format(profitRate);
    }
}
