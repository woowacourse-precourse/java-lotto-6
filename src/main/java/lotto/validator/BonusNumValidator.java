package lotto.validator;

public class BonusNumValidator {
    private static final String TYPE_ERROR = "[ERROR] 보너스 번호는 정수이어야 합니다.";
    private static final String RANGE_ERROR = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";

    public static int validate(String bonusNum) {
        int result = validateType(bonusNum);
        validateRange(result);
        return result;
    }

    private static int validateType(String input) {
        int result;
        try {
            result = Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(TYPE_ERROR);
        }
        return result;
    }

    private static void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(RANGE_ERROR);
        }
    }
}
