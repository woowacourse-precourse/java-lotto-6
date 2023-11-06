package lotto.domain.vo;

import lotto.constant.LottoConstants;
import lotto.util.validator.InputValidator;

public class TotalAmount {
    private final int amount;

    private TotalAmount(int amount) {
        this.amount = amount;
    }

    public static TotalAmount of(int amount, InputValidator<Integer> validator) {
        validator.validate(amount);
        return new TotalAmount(amount);
    }

    public TicketCount calculateTicketCount() {
        int count = amount / LottoConstants.PRICE_PER_LOTTO;
        return TicketCount.from(count);
    }
}
