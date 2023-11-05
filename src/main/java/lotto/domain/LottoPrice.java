package lotto.domain;

import lotto.config.ErrorMessage;
import lotto.config.LottoConfig;
import lotto.util.Parser;

public class LottoPrice {
    private static final int CORRECT_DIVISION = 0;
    private static final int LOTTO_PRICE = LottoConfig.PRICE.getValue();

    private final int price;

    public LottoPrice(String numericString) {
        int price = Parser.parseIntOrThrow(numericString);
        validateRange(price);
        validateDivision(price);
        this.price = price;
    }

    public int getTryCount() {
        return price / LOTTO_PRICE;
    }

    private void validateRange(int price) {
        if (price < LOTTO_PRICE) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_PRICE_RANGE.message());
        }
    }

    private void validateDivision(int price) {
        if (price % LOTTO_PRICE != CORRECT_DIVISION) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_PRICE_DIVISION.message());
        }
    }
}
