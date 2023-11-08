package lotto.model;

import lotto.config.LottoPrice;
import lotto.view.Messages;

public class Amount {

    private final int amount;

    public Amount(String amount) {
        validate(amount);
        this.amount = calculateLottosAmount(amount);
    }

    public int getAmount() {
        return amount;
    }

    private void validate(String amount) {
        try {
            int parsedAmount = Integer.parseInt(amount);
            if (parsedAmount < LottoPrice.LOTTO_PRICE.getValue()) {
                throw new IllegalArgumentException(Messages.LOTTO_PRICE_ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Messages.LOTTO_STATE_ERROR_MESSAGE);
        }
    }

    private int calculateLottosAmount(String amount) {
        return Integer.parseInt(amount) / LottoPrice.LOTTO_PRICE.getValue();
    }
}
