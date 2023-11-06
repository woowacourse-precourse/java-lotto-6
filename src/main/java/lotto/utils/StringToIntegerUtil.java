package lotto.utils;

import lotto.model.Money;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringToIntegerUtil {

    public static Money stringToMoney(String input) {
        if (containsThousandSeparator(input)) {
            validateCommaAtPosition(input);
            input = removeComma(input);
        }

        int amount = 0;

        try {
            amount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        
        return new Money(amount);
    }

    protected static boolean containsThousandSeparator(String input) {
        return input.contains(",");
    }

    protected static void validateCommaAtPosition(String input) {
        String regex = "^[0-9]{1,3}(,[0-9]{3})*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (!matcher.matches()) {
            throw new IllegalArgumentException();
        }
    }

    protected static String removeComma(String input) {
        return input.replaceAll(",", "");
    }

}
