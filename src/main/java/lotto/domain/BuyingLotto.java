package lotto.domain;

import static lotto.Validator.*;
import static lotto.constants.Numbers.*;
import static lotto.view.InputView.BUYING_PRICE;
import static lotto.view.OutputView.printTicketNumber;

public class BuyingLotto {
    private final int buyingPrice;
    private final int ticketNumber;

    public BuyingLotto() {
        this.buyingPrice = buyingPriceFromInput();
        this.ticketNumber = calculateTicketNumber(buyingPrice, LOTTO_PRICE);
    }

    public int getBuyingPrice() {
        return this.buyingPrice;
    }
    public int getTicketNumber() {
        return this.ticketNumber;
    }

    private int buyingPriceFromInput() {
        while (true) {
            String input = BUYING_PRICE.scan();
            try {
                validateNumberString(input);
                int buyingPrice = Integer.parseInt(input);
                validatePlusSign(buyingPrice);
                validateDivision(buyingPrice);
                return buyingPrice;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private int calculateTicketNumber(int buyingPrice, int unitPrice) {
        return buyingPrice / unitPrice;
    }
}
