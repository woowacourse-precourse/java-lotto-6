package lotto.utils;

import static java.util.regex.Pattern.compile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.constants.LottoConstants;

public class InputValidator {

    private static final String NUMBER_MATCH_REGEX = "^[0-9]*$";
    private static final int MIN_MONEY = 0;
    private static final int MAX_MONEY = 100000000;
    private static final Pattern NUMBER = compile(NUMBER_MATCH_REGEX);


    public static String validate(String input) {
        if (IsNull(input)) {
            throw new NullPointerException("[ERROR] 사용자의 입력이 null 입니다.");
        }
        if (IsEmptyString(input)) {
            throw new IllegalArgumentException("[ERROR] 사용자의 입력이 비어있습니다.");
        }
        if (isBlankString(input)) {
            throw new IllegalArgumentException("[ERROR] 사용자의 입력이 공백입니다.");
        }
        return input;
    }

    private static boolean IsEmptyString(String input) {
        return input.isEmpty();
    }

    private static boolean IsNull(String input) {
        return input == null;
    }

    private static boolean isBlankString(String input) {
        return input.isBlank();
    }

    public static String validateMoney(String input) {
        String money = input.replace(",", "");
        return validateInt(money);
    }

    public static void validateBonus(String input) {
        String bonus = validateInt(input);
        if (!IsRange(Integer.parseInt(bonus))) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] 보너스 번호는 %d 부터 %d 이내입니다.", LottoConstants.MIN_NUMBER.getConstants(),
                            LottoConstants.MAX_NUMBER.getConstants()));
        }
    }

    private static boolean IsRange(int bonus) {
        return LottoConstants.MIN_NUMBER.getConstants() <= bonus
                && bonus <= LottoConstants.MAX_NUMBER.getConstants();
    }

    public static String validateInt(String input) {
        if (!IsInPattern(input, NUMBER)) {
            throw new NumberFormatException("[ERROR] 정수만 입력해주세요");
        }
        if (!IsBoundary(input)) {
            throw new IllegalArgumentException("[ERROR] 최소 1원 이상, 1억원 미만으로 입력해주세요");
        }
        return input;
    }

    private static boolean IsInPattern(String input, Pattern pattern) {
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    private static boolean IsBoundary(String input) {
        return MIN_MONEY < Integer.parseInt(input) && Integer.parseInt(input) < MAX_MONEY;
    }

}
