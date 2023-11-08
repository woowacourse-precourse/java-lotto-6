package lotto.Validator;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {

    private static final String SEPARATOR = ",";
    private static final int MONEY_MIN_AMOUNT = 1000;
    private static final int MONEY_MAX_AMOUNT = 21 * 100000000;
    private static final int MONEY_UNIT = 1000;

    public static void validateBlankString(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 빈 문자열이 입력되었습니다");
        }
    }

    public static String[] seperateStrings(String input) {
        return input.split(SEPARATOR);
    }

    public static List<Integer> getListOfIntegerByStrings(String[] inputs) {
        List<Integer> numbers = new ArrayList<>();
        try {
            for (String number :
                    inputs) {
                numbers.add(Integer.parseInt(number));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력해주세요");
        }
        return numbers;
    }

    public static void validateMoney(long money) {
        if (money < MONEY_MIN_AMOUNT || money > MONEY_MAX_AMOUNT) {
            throw new IllegalArgumentException(
                    "[ERROR] 금액은 " + MONEY_MIN_AMOUNT + "원 이상 " + MONEY_MAX_AMOUNT + "원 이하인 값으로 입력해주세요.");
        }
        if (money % MONEY_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 " + MONEY_UNIT + "원 단위로 입력해주세요");
        }

    }
}
