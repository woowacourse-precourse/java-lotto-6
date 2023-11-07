package lotto;

public class LottoPurchaseAmount {

    public static final int AMOUNT_PER_TICKET = 1_000;

    private final int ticketsCount;

    public LottoPurchaseAmount(String purchaseAmount) {
        int amount = parsePurchaseAmount(purchaseAmount);
        validateAmount(amount);
        this.ticketsCount = amount / AMOUNT_PER_TICKET;
    }

    public int getTicketsCount() {
        return ticketsCount;
    }

    private int parsePurchaseAmount(String purchaseAmount) {
        int amount;
        try {
            amount = Integer.parseInt(purchaseAmount);
            // NOTE: 입력값이 유효한 정수가 아니거나 Integer.MAX_VALUE를 초과하는 경우 예외가 발생합니다.
        } catch (NumberFormatException e) {
            throw new NumberFormatException("구입 금액을 숫자로 입력해주세요. 입력값: " + purchaseAmount);
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("구입 금액은 양수로 입력해주세요. 입력값: " + amount);
        }
        return amount;
    }

    private void validateAmount(int amount) {
        if (amount % AMOUNT_PER_TICKET != 0) {
            throw new IllegalArgumentException(
                    String.format("구입 금액은 %d원의 배수로 입력해주세요. 입력값: %d", AMOUNT_PER_TICKET, amount));
        }
    }
}
