package lotto.domain;

public class Balance {
    private static final int LOTTO_TICKET_PRICE = 1000;
    private static final String INVALID_AMOUNT_MESSAGE = "[ERROR] 입력된 금액은 로또 티켓 가격(%d원)의 배수여야 합니다.";
    private final int amount;

    private Balance(int amount) {
        validatePurchaseWithoutChange(amount);
        this.amount = amount;
    }

    public static Balance create(int amount) {
        return new Balance(amount);
    }

    private void validatePurchaseWithoutChange(int amount) {
        if (isNotMultipleOfTicketPrice(amount)) {
            throw new IllegalArgumentException(String.format(INVALID_AMOUNT_MESSAGE, LOTTO_TICKET_PRICE));
        }
    }

    private boolean isNotMultipleOfTicketPrice(int amount) {
        return amount % LOTTO_TICKET_PRICE != 0;
    }
}
