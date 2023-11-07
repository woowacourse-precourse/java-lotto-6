package lotto;

public class InputValidator {
    private static final Integer PRICE_UNIT = 1000;
    private static final Integer PRICE_STANDARD = 1000;
    private static final Integer REMAIN_ZERO = 0;

    public void validatePrice(int userInput) {
        validateAmount(userInput);
        validateUnit(userInput);
    }

    private void validateUnit(int userInput) {
        if (isNotRequiredUnit(userInput)) {
            throw new IllegalArgumentException(PRICE_UNIT + "원 단위 이외의 금액은 입력할 수 없습니다.");
        }
    }

    private boolean isNotRequiredUnit(int userInput) {
        return userInput % PRICE_UNIT != REMAIN_ZERO;
    }

    private void validateAmount(int userInput) {
        if (isLowerThanStandard(userInput)) {
            throw new IllegalArgumentException(PRICE_STANDARD + "원 미만의 금액은 입력할 수 없습니다.");
        }
    }

    private boolean isLowerThanStandard(int userInput) {
        return userInput < PRICE_STANDARD;
    }
}
