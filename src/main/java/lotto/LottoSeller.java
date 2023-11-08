package lotto;

import lotto.exception.lottoseller.InsufficientMoneyException;
import lotto.exception.lottoseller.NonMultipleMoneyException;

public class LottoSeller {
    public static final int LOTTO_PRICE = 1000;
    private final LottoPublisher lottoPublisher;

    public LottoSeller(LottoPublisher lottoPublisher) {
        this.lottoPublisher = lottoPublisher;
    }

    public LottoBundle sell(Money payedMoney) {
        validateOverSingleLottoPrice(payedMoney);
        validateMultipleOfLottoPrice(payedMoney);
        int lottoCount = calculateLottoCount(payedMoney);
        return lottoPublisher.publishBundle(lottoCount);
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

    private int calculateLottoCount(Money payedMoney) {
        return payedMoney.divide(LOTTO_PRICE);
    }
}
