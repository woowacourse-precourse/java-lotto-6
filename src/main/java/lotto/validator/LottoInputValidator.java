package lotto.validator;

import static lotto.util.Util.changeStringToInt;

public class LottoInputValidator {
    public static final int THOUSAND = 1000;
    public static final int ZERO = 0;
    public static final int SIX = 6;
    public static final int ONE = 1;
    public static final int FORTY_FIVE = 45;

    public static boolean isNumber(String number) {
        boolean isNumeric = true;
        for (int index = 0; index < number.length(); index++) {
            if (!Character.isDigit(number.charAt(index))) {
                isNumeric = false;
                break; // 숫자가 아닌 경우에는 더 이상 검사하지 않고 바로 반복문 종료
            }
        }
        return isNumeric;
    }

    public static boolean isOverOneUnderFortyFive(int number) {
        return (number >= ONE && number <= FORTY_FIVE);
    }

    public static void validateBonusNumberNumeric(String number) {
        if (!isNumber(number)) {
            throw new IllegalArgumentException("[ERROR]: 보너스 번호는 1과 45사이의 숫자여야 합니다.");
        }
    }

    public static void validateBonusNumberRange(int number) {
        if (!isOverOneUnderFortyFive(number)) {
            throw new IllegalArgumentException("[ERROR]: 보너스 번호는 1과 45사이의 숫자여야 합니다.");
        }
    }

    public static void validateBonusNumber(String number) {
        validateBonusNumberNumeric(number);
        int num = changeStringToInt(number);
        validateBonusNumberRange(num);
    }

    private static void validateWinningNumberCount(String[] numbersArray) {
        if (numbersArray.length != SIX) {
            throw new IllegalArgumentException("[ERROR]: 입력된 숫자의 개수가 6개가 아닙니다.");
        }
    }

    private static void validateWinningNumberFormat(String number) {
        if (!number.matches("\\d{1,2}(,\\d{1,2}){5}")) {
            throw new IllegalArgumentException("[ERROR]: 유효한 입력이 아닙니다.");
        }
    }

    public static void validateWinningNumber(String number) {
        String[] numbersArray = number.split(",");
        validateWinningNumberFormat(number);
        validateWinningNumberCount(numbersArray);

        for (String num : numbersArray) {
            if (!isNumber(num) || !isOverOneUnderFortyFive(Integer.parseInt(num))) {
                throw new IllegalArgumentException("[ERROR]: 입력된 숫자가 1과 45사이의 유효한 숫자가 아닙니다.");
            }
        }
    }

    public static void validatePurchaseMoneyNumeric(String number) {
        if (!isNumber(number)) {
            throw new IllegalArgumentException("[ERROR]: 구입 금액은 1000의 배수로 된 숫자를 입력해야 합니다.");
        }
    }

    public static void validateThousandMultiple(int number) {
        if (number % THOUSAND != ZERO) {
            throw new IllegalArgumentException("[ERROR]: 입력된 숫자가 1000의 배수가 아닙니다.");
        }
    }

    public static void validateUnderThousand(int number) {
        if (number < THOUSAND) {
            throw new IllegalArgumentException("[ERROR]: 입력된 숫자가 1000보다 작습니다.");
        }
    }

    public static void validatePurchaseMoney(String number) {
        validatePurchaseMoneyNumeric(number);
        int num = changeStringToInt(number);
        validateThousandMultiple(num);
        validateUnderThousand(num);
    }
}
