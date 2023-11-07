package lotto.domain;

public class Balance {
    private static final int LOTTO_TICKET_PRICE = 1000;
    private static final String INVALID_AMOUNT_MESSAGE = "[ERROR] 입력된 금액은 로또 티켓 가격(%d원)의 배수여야 합니다.";
    private static final String INSUFFICIENT_BALANCE_MESSAGE = "[ERROR] 잔액이 부족합니다. 로또 티켓을 더 이상 구매할 수 없습니다.";

    private int amount;
    private final int purchaseAmount;

    private Balance(int amount) {
        validatePurchaseWithoutChange(amount);
        this.amount = amount;
        this.purchaseAmount = amount;
    }

    public static Balance create(int amount) {
        return new Balance(amount);
    }

    public boolean hasSufficientBalance() {
        return amount >= LOTTO_TICKET_PRICE;
    }

    public void deductTicketPrice() {
        if (!hasSufficientBalance()) {
            throw new IllegalStateException(INSUFFICIENT_BALANCE_MESSAGE);
        }

        amount -= LOTTO_TICKET_PRICE;
    }
    
    public int getPurchaseAmount() {
        return purchaseAmount;
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
