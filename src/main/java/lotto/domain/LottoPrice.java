package lotto.domain;

import lotto.config.LottoConfig;

public class LottoPrice {
    private final String NUMERIC_STRING_ERROR = "[ERROR] 숫자형태의 입력이 아닙니다.";
    private final String MINIMUM_PRICE_ERROR = "[ERROR] 1000이상의 값을 입력해야 합니다.";
    private final String PRICE_DIVISION_ERROR = "[ERROR] 1000단위의 값을 입력해야 합니다.";
    private final int CORRECT_DIVISION = 0;
    private final int LOTTO_PRICE = LottoConfig.PRICE.getValue();

    private final int price;

    public LottoPrice(String numericString) {
        int price = parseIntOrThrow(numericString);
        validateRange(price);
        validateDivision(price);
        this.price = price;
    }

    public int getTryCount() {
        return price / LOTTO_PRICE;
    }

    private int parseIntOrThrow(String numericString) {
        try {
            return Integer.parseInt(numericString);
        } catch (Exception e) {
            throw new IllegalArgumentException(NUMERIC_STRING_ERROR);
        }
    }

    private void validateRange(int price) {
        if (price < LOTTO_PRICE) {
            throw new IllegalArgumentException(MINIMUM_PRICE_ERROR);
        }
    }

    private void validateDivision(int price) {
        if (price % LOTTO_PRICE != CORRECT_DIVISION) {
            throw new IllegalArgumentException(PRICE_DIVISION_ERROR);
        }
    }
}
