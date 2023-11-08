package lotto;

import static lotto.Constants.*;

public class BuyingPrice extends InputNumber {

    private Integer price;

    public BuyingPrice() {
        this.price = 0;
    }

    public Integer getPrice() {
        return this.price;
    }

    public Integer getBuyingCount() {
        return this.price / 1000;
    }

    public void printCount() {
        System.out.println(getBuyingCount() + BUYING_COUNT);
    }

    public void save(String readLine) {
        Integer price = validate(readLine);
        this.price = price;
    }

    protected Integer validate(String readLine) {
        String noEmptyReadLine = removeEmpty(readLine);
        checkDigit(noEmptyReadLine);
        Integer price = translateToValueType(noEmptyReadLine);
        checkBoundary(price);
        checkRest(price);
        return price;
    }

    @Override
    protected void checkDigit(String noEmptyReadLine) {
        if (noEmptyReadLine.length() == 0) {
            throw new IllegalArgumentException(BUYING_PRICE_DIGIT_ERROR);
        }
    }

    @Override
    protected void checkBoundary(Integer price) {
        if (price < 1000 || price > 100000) {
            throw new IllegalArgumentException(BUYING_PRICE_BOUNDARY_ERROR);
        }
    }

    private void checkRest(Integer price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(BUYING_PRICE_REST_ERROR);
        }
    }
}
