package lotto.domain;

import static lotto.Validator.*;
import static lotto.NumberConstants.*;

public class BuyingLotto {
    private final int buyingPrice;
    private final int ticketNumber;

    public BuyingLotto(int buyingPrice) {
        validatePlusSign(buyingPrice);
        validateDivision(buyingPrice);
        this.buyingPrice = buyingPrice;
        this.ticketNumber = calculateTicketNumber(LOTTO_PRICE);
    }

    public int getBuyingPrice() {
        return this.buyingPrice;
    }
    public int getTicketNumber() {
        return this.ticketNumber;
    }

    private int calculateTicketNumber(int ticketPrice) {
        return buyingPrice / ticketPrice;
    }
}
