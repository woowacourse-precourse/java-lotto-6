package lotto.domain;

import lotto.common.constants.LottoRule;
import lotto.common.validate.Validate;

public class BuyInformation {
    private final int money;
    private final int buyTicketCount;

    public BuyInformation(String price) {
        validatePrice(price);
        this.money = Integer.parseInt(price);
        this.buyTicketCount = money / LottoRule.ONE_LOTTO_TICKET_PRICE.getRule();
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
