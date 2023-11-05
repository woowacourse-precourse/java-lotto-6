package lotto.utils;

import static java.util.regex.Pattern.compile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputConvertor {
    private static final String NUMBER_MATCH_REGEX = "[+-]?\\d*(\\.\\d+)?";
    private static final int MIN_MONEY = 0;
    private static final int MAX_MONEY = 100000000;
    private static final Pattern NUMBER = compile(NUMBER_MATCH_REGEX);

    private static int convertStringtoInt(String input) {
        if (!IsInteger(input)) {
            throw new NumberFormatException("[ERROR] 정수만 입력해주세요");
        }
        if (!IsBoundary(input)) {
            throw new IllegalArgumentException("[ERROR] 최소 1원 이상, 1억원 미만으로 입력해주세요");
        }
        return Integer.parseInt(input);
    }

    private static boolean IsBoundary(String input) {
        Matcher matcher = NUMBER.matcher(input);
        return matcher.matches();
    }

    private static boolean IsInteger(String input) {
        return MIN_MONEY < Integer.parseInt(input) && Integer.parseInt(input) < MAX_MONEY;
    }

    public static int convertMoney(String input) {
        return convertStringtoInt(input.replace(",", ""));
    }

}
