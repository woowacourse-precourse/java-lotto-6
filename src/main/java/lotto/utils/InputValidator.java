package lotto.utils;

import static java.util.regex.Pattern.compile;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.constants.InputConstants;
import lotto.constants.LottoConstants;

public class InputValidator {

    private static final String NUMBER_MATCH_REGEX = "^[0-9]*$";
    private static final int MIN_MONEY = 0;
    private static final int MAX_MONEY = 100000000;
    private static final Pattern NUMBER = compile(NUMBER_MATCH_REGEX);


    public static String validate(final String input) {
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

    private static boolean IsEmptyString(final String input) {
        return input.isEmpty();
    }

    private static boolean IsNull(final String input) {
        return input == null;
    }

    private static boolean isBlankString(final String input) {
        return input.isBlank();
    }

    public static String validateMoney(final String input) {
        String money = input.replace(",", "");
        return validateInt(money);
    }

    public static String validateWinnings(final String winnings) {
        List<String> input = Arrays.asList(winnings.split(InputConstants.WINNING_DELIMITER.getConstants()));
        List<String> duplicated = input.stream().map(InputValidator::validateLottoNumber).distinct().toList();
        if (input.size() != duplicated.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
        if (duplicated.size() != LottoConstants.LENGTH.getConstants()) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] %d개로 로또를 생성하려 했습니다. 로또의 번호는 6개 입니다", duplicated.size()));
        }
        return winnings;
    }

    public static String validateLottoNumber(final String input) {
        String number = validateInt(input);
        if (!IsRange(number)) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] 로또 번호는 %d 부터 %d 이내입니다.", LottoConstants.MIN_NUMBER.getConstants(),
                            LottoConstants.MAX_NUMBER.getConstants()));
        }
        return number;
    }

    private static boolean IsRange(final String input) {
        int number = Integer.parseInt(input);
        return LottoConstants.MIN_NUMBER.getConstants() <= number
                && number <= LottoConstants.MAX_NUMBER.getConstants();
    }

    public static String validateInt(final String input) {
        if (!IsInPattern(input, NUMBER)) {
            throw new NumberFormatException("[ERROR] 양의 정수만 입력해주세요");
        }
        if (!IsBoundary(input)) {
            throw new IllegalArgumentException("[ERROR] 최소 1원 이상, 1억원 미만으로 입력해주세요");
        }
        return input;
    }

    private static boolean IsInPattern(final String input, final Pattern pattern) {
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    private static boolean IsBoundary(final String input) {
        try {
            int isInt = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] int의 범위를 벗어났습니다.");
        }
        return MIN_MONEY < Integer.parseInt(input) && Integer.parseInt(input) < MAX_MONEY;
    }

}
