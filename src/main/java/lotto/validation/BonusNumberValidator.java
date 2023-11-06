package lotto.validation;

public class BonusNumberValidator {
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;

    private static int parseToInt(String numberStr) {
        try {
            return Integer.parseInt(numberStr.trim());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.", exception);
        }
    }

    private static void validateNumberInRange(int number) {
        if (number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 숫자는 " + MINIMUM_NUMBER + "에서 " + MAXIMUM_NUMBER + " 사이어야 합니다: " + number);
        }
    }



}
