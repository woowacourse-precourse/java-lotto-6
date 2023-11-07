package lotto.domain.money;

import static lotto.domain.money.LottoMoneyConfig.LOTTO_COST;
import static lotto.domain.money.LottoMoneyErrorMessage.MONEY_CANNOT_BE_DIVIDED;
import static lotto.domain.money.LottoMoneyErrorMessage.MONEY_NOT_MORE_THAN_ZERO;

public class Money {

    private final int userMoney;

    public Money(int userMoney) {
        validateMoney(userMoney);
        this.userMoney = userMoney;
    }

    public int getNumberOfLottos() {
        return userMoney / LOTTO_COST.getValue();
    }

    private void validateMoney(int money) {
        if(validateMoneyNotMoreThanZero(money)) {
            throw new IllegalArgumentException(MONEY_NOT_MORE_THAN_ZERO.toString());
        }
        if(validateMoneyDevidedByCost(money)) {
            throw new IllegalArgumentException(MONEY_CANNOT_BE_DIVIDED.toString());
        }
    }

    private boolean validateMoneyNotMoreThanZero(int money) {
        return (money <= 0);
    }

    private boolean validateMoneyDevidedByCost(int money) {
        return (money % LOTTO_COST.getValue() != 0);
    }


}
