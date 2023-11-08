package lotto;

import static lotto.LottoProperty.LOTTO_PRICE;

public class LottoAmount {
    private final int lottoAmount;

    public LottoAmount(String stringCash) {
        validate(stringCash);
        this.lottoAmount = Integer.parseInt(stringCash) / LOTTO_PRICE.getLottoProperty();
    }

    private void validate(String stringCash) {
        int cash = validateNumber(stringCash);
        validateRange(cash);
        validatePriceMultiple(cash);
    }

    private int validateNumber(String stringCash) {
        try {
            return Integer.parseInt(stringCash);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구매금액에는 숫자를 입력하시오.");
        }
    }

    private void validateRange(int cash) {
        if (cash <= 0) {
            throw new IllegalArgumentException("[ERROR] 구매금액에는 0보다 큰 숫자를 입력하시오.");
        }
    }

    private void validatePriceMultiple(int cash) {
        if (cash % LOTTO_PRICE.getLottoProperty() != 0) {
            throw new IllegalArgumentException
                    ("[ERROR] 구매금액은" + LOTTO_PRICE.getLottoProperty() + "의 배수를 입력하시오.");
        }
    }

    public int getLottoAmount() {
        return this.lottoAmount;
    }
}
