package lotto;

import lotto.exception.lottoseller.InsufficientMoneyException;
import lotto.exception.lottoseller.NonMultipleMoneyException;

public class LottoSeller {
    public static final int LOTTO_PRICE = 1000;

    public LottoBundle sell(Money payedMoney) {
        validateOverSingleLottoPrice(payedMoney);
        validateMultipleOfLottoPrice(payedMoney);
        return publishLottoBundle(payedMoney);
    }

    private void validateOverSingleLottoPrice(Money payedMoney) {
        if (!isOverSingleLottoPrice(payedMoney)) {
            throw new InsufficientMoneyException();
        }
    }

    private void validateMultipleOfLottoPrice(Money payedMoney) {
        if (!isMultipleOfLottoPrice(payedMoney)) {
            throw new NonMultipleMoneyException();
        }
    }

    private boolean isOverSingleLottoPrice(Money payedMoney) {
        return payedMoney.isGreaterEqual(LOTTO_PRICE);
    }

    private boolean isMultipleOfLottoPrice(Money payedMoney) {
        return payedMoney.isMultipleOf(LOTTO_PRICE);
    }

    private LottoBundle publishLottoBundle(Money payedMoney) {
        int lottoCountToPublish = calculateLottoCountToPublish(payedMoney);

        return null;
    }

    private int calculateLottoCountToPublish(Money payedMoney) {
        return payedMoney.divide(LOTTO_PRICE);
    }
}
