package lotto.validator;

import static lotto.util.Util.changeStringToInt;

public class LottoInputValidator {
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
        return (number >= 1 && number <= 45);
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

    public static void validateWinningNumberNumeric(String number) {
        if (!isNumber(number)) {
            throw new IllegalArgumentException("[ERROR]: 당첨 번호는 1과 45사이의 숫자여야 합니다.");
        }
    }

    public static void validateWinningNumberRange(int number) {
        if (!isOverOneUnderFortyFive(number)) {
            throw new IllegalArgumentException("[ERROR]: 당첨 번호는 1과 45사이의 숫자여야 합니다.");
        }
    }

    private static void validateWinningNumberCount(String[] numbersArray) {
        if (numbersArray.length != 6) {
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


}
