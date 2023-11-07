package lotto.domain;

import lotto.common.constants.LottoDefaultRule;
import lotto.common.validate.Validate;

public class Buy {
    private final int buyPrice;
    private final int buyTicketCount;

    public Buy(String price) {
        this.buyPrice = validate(price);
        this.buyTicketCount = buyPrice / LottoDefaultRule.ONE_LOTTO_TICKET_PRICE.getRule();
    }

    private int validate(String inputPrice) {
        try {
            Validate.buyPriceValidate(inputPrice);
            return Integer.parseInt(inputPrice);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    public int getBuyPrice() {
        return buyPrice;
    }

    public int getBuyTicketCount() {
        return buyTicketCount;
    }
}
