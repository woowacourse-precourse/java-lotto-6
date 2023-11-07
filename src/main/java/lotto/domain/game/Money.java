package lotto.domain.game;

import lotto.constants.ErrorConsts;
import lotto.constants.LottoConsts;

public record Money(
        int price
) {
    public Money {
        validate(price);
    }

    private void validate(final int price) {
        validateDividedByLottoPrice(price);
    }

    private void validateDividedByLottoPrice(final int price) {
        if (price % LottoConsts.LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(ErrorConsts.MONEY_NOT_DIVIDED_BY_LOTTO_PRICE.getMessage());
        }
    }

    public int countLotto() {
        return price / LottoConsts.LOTTO_PRICE.getValue();
    }
}
