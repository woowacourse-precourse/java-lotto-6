package lotto.domain;

public class MoneyManagement {
    private final int quantity;

    public MoneyManagement(final String userInput) {
        validate(userInput);
        this.quantity = toInt(userInput);
    }

    private void validate(final String userInput) {
        validNumber(userInput);
        int userAmount = toInt(userInput);
    }

    private void validNumber(final String userInput) {
        if (!userInput.matches("%d")) {
            throw new IllegalArgumentException("금액은 숫자만 입력 가능합니다.");
        }
    }

    private int toInt(String userInput) {
        return Integer.parseInt(userInput);
    }

}
