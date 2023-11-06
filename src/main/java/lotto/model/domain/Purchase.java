package lotto.model.domain;

import static lotto.util.Constants.PURCHASE_PRICE_UNIT;
import static lotto.util.ExceptionMessage.PURCHASE_INVALID_TYPE;
import static lotto.util.ExceptionMessage.PURCHASE_INVALID_UNIT;

import lotto.util.InputValidator;

public class Purchase implements InputValidator {
    private Integer price;
    private Integer ticketCount;

    @Override
    public boolean getInputUntilValid() {
        return (price == null || ticketCount == null);
    }

    public void setOrderInfo(String order) {
        this.price = validateIntegerInput(order);
        this.ticketCount = validatePriceInThousandUnit(price);
    }

    private int validateIntegerInput(String price) {
        try {
            return Integer.parseInt(price);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PURCHASE_INVALID_TYPE.getMessage());
        }
    }

    private int validatePriceInThousandUnit(int price) {
        if(price % PURCHASE_PRICE_UNIT != 0) {
            throw new IllegalArgumentException(PURCHASE_INVALID_UNIT.format(PURCHASE_PRICE_UNIT));
        }
        return price/PURCHASE_PRICE_UNIT;
    }

    public Integer getTicketCount() {
        return ticketCount;
    }

    public Integer getPrice() {
        return price;
    }
}
