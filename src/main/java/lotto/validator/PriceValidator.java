package lotto.validator;

public class PriceValidator {
    private static final Integer PRICE_UNIT = 1000;
    private static final Integer PRICE_STANDARD = 1000;
    private static final Integer REMAIN_ZERO = 0;

    public static Integer validatePrice(int userInput) {
        validateAmount(userInput);
        validateUnit(userInput);

        return userInput;
    }

    private static void validateUnit(int userInput) {
        if (isNotRequiredUnit(userInput)) {
            throw new IllegalArgumentException(PRICE_UNIT + "원 단위 이외의 금액은 입력할 수 없습니다.");
        }
    }

    private static boolean isNotRequiredUnit(int userInput) {
        return userInput % PRICE_UNIT != REMAIN_ZERO;
    }

    private static void validateAmount(int userInput) {
        if (isLowerThanStandard(userInput)) {
            throw new IllegalArgumentException(PRICE_STANDARD + "원 미만의 금액은 입력할 수 없습니다.");
        }
    }

    private static boolean isLowerThanStandard(int userInput) {
        return userInput < PRICE_STANDARD;
    }
}
