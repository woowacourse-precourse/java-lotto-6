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
        validRange(userAmount);
        validLottoAmount(userAmount);
    }

    private void validNumber(final String userInput) {
        if (!userInput.matches("\\d+")) {
            throw new IllegalArgumentException("금액은 숫자만 입력 가능합니다.");
        }
    }

    private int toInt(final String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력한 금액이 유효한 숫자 범위를 벗어났습니다.");
        }
    }

    private void validRange(final int userAmount) {
        if (userAmount < 1000) {
            throw new IllegalArgumentException("로또 최소 구입 가능 금액은 1000원입니다.");
        }
    }

    private void validLottoAmount(final int userAmount) {
        if (userAmount % 1000 != 0) {
            throw new IllegalArgumentException("로또 금액은 1000원 단위입니다.");
        }
    }

    public int getQuantity() {
        return quantity;
    }
}
