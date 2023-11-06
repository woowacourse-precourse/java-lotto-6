package lotto.domain;

public class MoneyManagement {
    private final int quantity;
    private static final int LOTTO_AMOUNT = 1000;
    private static final int ZERO = 0;
    private static final String NUMERIC_PATTERN = "\\d+";

    private MoneyManagement(final String userInput) {
        validate(userInput);
        quantity = toInt(userInput) / LOTTO_AMOUNT ;
    }

    public static MoneyManagement from(final String userInput) {
        return new MoneyManagement(userInput);
    }

    private void validate(final String userInput) {
        validNumber(userInput);
        int userAmount = toInt(userInput);
        validRange(userAmount);
        validLottoAmount(userAmount);
    }

    private void validNumber(final String userInput) {
        if (!userInput.matches(NUMERIC_PATTERN)) {
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
        if (userAmount < LOTTO_AMOUNT) {
            throw new IllegalArgumentException("로또 최소 구입 가능 금액은 1000원입니다.");
        }
    }

    private void validLottoAmount(final int userAmount) {
        if (userAmount % LOTTO_AMOUNT != ZERO) {
            throw new IllegalArgumentException("로또 금액은 1000원 단위입니다.");
        }
    }

    public int getQuantity() {
        return quantity;
    }
    
}
