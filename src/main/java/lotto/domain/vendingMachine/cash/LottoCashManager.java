package lotto.domain.vendingMachine.cash;

import lotto.constants.LottoConstants;

public class LottoCashManager implements CashManager {
    private Integer money;

    @Override
    public void insertMoney(Integer money) {
        valid(money);
        this.money = money;
    }

    private void valid(Integer money) {
        isNotEndWithLottoPrice(money);
    }

    private void isNotEndWithLottoPrice(Integer number) {
        if (number % LottoConstants.LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException("금액은 " + LottoConstants.LOTTO_PRICE.getValue() + "단위로 입력하셔야합니다.");
        }
    }
}
