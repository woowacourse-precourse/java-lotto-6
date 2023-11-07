package lotto.domain;

import lotto.common.constants.LottoDefaultRule;
import lotto.common.validate.Validate;

public class Buy {
    private final int money;
    private final int buyTicketCount;

    public Buy(String price) {
        this.money = validate(price);
        this.buyTicketCount = money / LottoDefaultRule.ONE_LOTTO_TICKET_PRICE.getRule();
    }

    private int validate(String inputPrice) {
        try {
            Validate.buyPriceValidate(inputPrice);
            return Integer.parseInt(inputPrice);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    public int getMoney() {
        return money;
    }

    public int getBuyTicketCount() {
        return buyTicketCount;
    }
}
