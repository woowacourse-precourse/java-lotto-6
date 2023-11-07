package lotto;

import static lotto.Constants.*;

public class BuyingPrice extends Input {
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

    protected String removeEmpty(String readLine) {
        return readLine.replaceAll("\\s", "");
    }

    private void checkDigit(String readLine) {
        if (readLine.length() > 6) {
            throw new IllegalArgumentException(BUYING_PRICE_DIGIT_ERROR);
        }
    }

    protected Integer translateToValueType(String noEmptyReadLine) {
        try {
            return Integer.parseInt(noEmptyReadLine);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_TYPE_ERROR);
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
