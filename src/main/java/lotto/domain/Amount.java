package lotto.domain;

public class Amount {
    private final int amount;

    public Amount(String amount) {
        this.amount = convertToInteger(amount.strip());
        validate(this.amount);
    }

    public int getAmount() {
        return amount;
    }

    private int convertToInteger(final String amount) {
        try {
            return Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.AMOUNT_NOT_INTEGER.getMessage());
        }
    }

    private void validate(final int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.AMOUNT_NOT_POSITIVE.getMessage());
        } else if (amount % LottoInfo.PRICE.getNumber() != 0) {
            throw new IllegalArgumentException(ExceptionMessage.AMOUNT_NOT_DIVIDED_BY_PRICE.getMessage());
        }
    }
}
