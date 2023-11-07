package lotto.model;

import java.util.List;

public class LottoTicket extends Lotto{

    private final static int TICKET_PRICE = 1000;

    public LottoTicket(List<Integer> numbers, final int buyingCost) {
        super(numbers);
        validatePurchaseAmount(buyingCost);
    }

    private void validatePurchaseAmount(final int buyingCost) {
        // 조건문 고칠 수 있으면 고쳐봐
        if (buyingCost < TICKET_PRICE || buyingCost % TICKET_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }
}
