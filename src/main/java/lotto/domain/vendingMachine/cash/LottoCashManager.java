package lotto.domain.vendingMachine.cash;

import lotto.constants.LottoConstants;

public class LottoCashManager implements CashManager {
    private Integer money;

    @Override
    public void insertMoney(Integer money) throws IllegalArgumentException{
        valid(money);
        this.money = money;
    }

    private void valid(Integer money) throws IllegalArgumentException{
        isNotEndWithLottoPrice(money);
    }

    private void isNotEndWithLottoPrice(Integer number) throws IllegalArgumentException{
        if (number % LottoConstants.LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 " + LottoConstants.LOTTO_PRICE.getValue() + "단위로 입력하셔야합니다.");
        }
    }
    public Integer getMoney() {
        return money;
    }
}
