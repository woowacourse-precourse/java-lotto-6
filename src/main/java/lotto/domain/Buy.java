package lotto.domain;

import lotto.common.constants.LottoDefaultRule;
import lotto.common.validate.Validate;

public class Buy {
    private final int money;
    private final int buyTicketCount;

    public Buy(String price) {
        validatePrice(price);
        this.money = Integer.parseInt(price);
        this.buyTicketCount = money / LottoDefaultRule.ONE_LOTTO_TICKET_PRICE.getRule();
    }

    private void validatePrice(String inputPrice) {
        Validate.buyDomainValidate(inputPrice);
    }

    public int getMoney() {
        return money;
    }

    public int getBuyTicketCount() {
        return buyTicketCount;
    }
}
