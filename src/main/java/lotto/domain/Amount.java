package lotto.domain;

public class Amount {
    private final int amount;

    public Amount(String amount) {
        this.amount = convertToInteger(amount);
        validate(this.amount);
    }

    public int getAmount() {
        return amount;
    }

    private int convertToInteger(String amount) {
        try {
            return Integer.parseInt(amount.strip());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionType.AMOUNT_NOT_INTEGER.getMessage());
        }
    }

    private void validate(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(ExceptionType.AMOUNT_NOT_POSITIVE.getMessage());
        } else if (amount % LottoConstants.PRICE.getNumber() != 0) {
            throw new IllegalArgumentException(ExceptionType.AMOUNT_NOT_DIVIDED_BY_PRICE.getMessage());
        }
    }
}
