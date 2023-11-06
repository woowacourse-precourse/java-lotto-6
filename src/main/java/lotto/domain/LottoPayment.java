package lotto.domain;

import static lotto.domain.constants.LottoConstants.LOTTO_PRICE;

public class LottoPayment {

    public int calculateNumberOfLottos(final int money) {
        validateRange(money);
        return money / LOTTO_PRICE;
    }

    private void validateRange(final int money) {
        validatePositive(money);
        validateNoRemainder(money);
    }

    private void validatePositive(final int money) {
        if (money <= 0) {
            throw new IllegalArgumentException("금액은 " + LOTTO_PRICE + " 이상만 입력할 수 있습니다.");
        }
    }

    private void validateNoRemainder(final int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("금액은 " + LOTTO_PRICE + " 단위로만 입력할 수 있습니다.");
        }
    }
}
