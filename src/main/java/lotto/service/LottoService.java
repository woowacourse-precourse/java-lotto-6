package lotto.service;

import static lotto.model.Lotto.LOTTO_PRICE;

import lotto.exception.LottoPriceUnitException;
import lotto.model.Money;

public class LottoService {

    public void buyLotto(Money money) {
        validateUnit(money);

        // TODO: 로또 발행 요청
    }

    /**
     * 로또 구입 금액이 1,000 단위가 맞는지 확인한다.
     */
    public void validateUnit(Money money) {
        int remain = money.getMoney() % LOTTO_PRICE;
        if (remain != 0) {
            throw new LottoPriceUnitException();
        }
    }
}
