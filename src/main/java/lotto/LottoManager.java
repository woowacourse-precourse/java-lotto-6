package lotto;

import java.util.List;
import lotto.exception.lottomanager.InsufficientMoneyException;
import lotto.exception.lottomanager.NonMultipleMoneyException;

public class LottoManager {
    public static final int LOTTO_PRICE = 1000;

    public List<Lotto> sell(Money payedMoney) {
        validateOverSingleLottoPrice(payedMoney);
        validateMultipleOfLottoPrice(payedMoney);
        return publishLottos(payedMoney);
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

    private List<Lotto> publishLottos(Money payedMoney) {
        // TODO: 로또 발행 로직 구현
        return null;
    }
}
