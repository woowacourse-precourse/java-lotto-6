package lotto.validator;

import java.util.List;

public class InputValidator {

    private final static String DIGIT_REGEX = "^[0-9]+$";
    private final static long LOTTO_TICKET_PRICE = 1000L;
    private final static int START_RANGE = 1;
    private final static int END_RANGE = 45;
    private final static long MAX_PURCHASE_AMOUNT = (Long.MAX_VALUE / LOTTO_TICKET_PRICE) * LOTTO_TICKET_PRICE;
    private final static String IS_NOT_DIGIT_MSG = "[ERROR] 로또 구입 금액은 숫자만 입력할 수 있습니다.";
    private final static String OVER_MAX_LIMIT_MSG = "[ERROR] 입력할 수 있는 최대값을 넘었습니다.";
    private final static String ERROR_INVALID_AMOUNT_MSG = "[ERROR] 구입 금액은 1000원 이상이어야 하며, 1000원 단위로 나누어 떨어져야한다.";
    private final static String INVALID_RANGE_MSG = "[ERROR] 1 ~ 45 사이의 숫자만 가능합니다.";
    private final static String DUPLICATE_MSG = "[ERROR] 보너스 번호는 로또 번호와 중복이 불가합니다.";

    public static void validateAmountFormatAndLimit(String money) throws IllegalArgumentException{
        if (!isDigit(money)) {
            throw new IllegalArgumentException(IS_NOT_DIGIT_MSG);
        }

        if (isPurchaseAmountExceeded(money)) {
            throw new IllegalArgumentException(OVER_MAX_LIMIT_MSG);
        }
    }

    public static void checkBonusNumber(List<Integer> lotto, String number) {
        if (!isDigit(number)) {
            throw new IllegalArgumentException(IS_NOT_DIGIT_MSG);
        }
        int bonusNumber = Integer.parseInt(number);

        if (bonusNumber < START_RANGE || bonusNumber > END_RANGE) {
            throw new IllegalArgumentException(INVALID_RANGE_MSG);
        }

        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_MSG);
        }
    }

    public static void validateAmountUnitAndMinimum(long money) throws IllegalArgumentException {
        if (isLessThanMinimum(money) || isNotMultipleOfUnit(money)) {
            throw new IllegalArgumentException(ERROR_INVALID_AMOUNT_MSG);
        }
    }

    private static boolean isDigit(String number) {
        return number.matches(DIGIT_REGEX);
    }

    private static boolean isPurchaseAmountExceeded(String money) {
        return Long.parseLong(money) > MAX_PURCHASE_AMOUNT;
    }

    private static boolean isLessThanMinimum(long money) {
        return money < LOTTO_TICKET_PRICE;
    }

    private static boolean isNotMultipleOfUnit(long money) {
        return money % LOTTO_TICKET_PRICE > 0;
    }
}
