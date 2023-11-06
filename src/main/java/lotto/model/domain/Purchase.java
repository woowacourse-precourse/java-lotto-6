package lotto.model.domain;

import lotto.util.InputValidator;

public class Purchase implements InputValidator {
    private static final int PURCHASE_PRICE_UNIT = 1000;
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
            throw new IllegalArgumentException("[ERROR] 숫자로만 입력해주세요. 예시) 1000 or 2000 ..");
        }
    }

    private int validatePriceInThousandUnit(int price) {
        if(price % PURCHASE_PRICE_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 " + PURCHASE_PRICE_UNIT + "단위로 입력해주세요.");
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
