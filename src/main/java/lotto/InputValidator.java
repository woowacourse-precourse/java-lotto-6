package lotto;

public class InputValidator {
    public void validatePrice(int userInput) {
        validateUnit(userInput);
    }

    private void validateUnit(int userInput) {
        if (isNotRequiredUnit(userInput)) {
            throw new IllegalArgumentException("1000원 단위 이외의 금액은 입력할 수 없습니다.");
        }
    }

    private boolean isNotRequiredUnit(int userInput) {
        return userInput % 1000 != 0;
    }
}
