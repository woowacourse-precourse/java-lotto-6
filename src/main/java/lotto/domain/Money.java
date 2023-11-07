package lotto.domain;

import lotto.config.GameConfig;
import lotto.exception.LottoGameException;
import lotto.exception.MoneyException;

public record Money(int amount) {

    public Money {
        validateMoney(amount);
    }

    private void validateMoney(int amountOfMoney) {
       validateRange(amountOfMoney);
       validateUnit(amountOfMoney);
    }

    private void validateRange(int amountOfMoney) {
        if (amountOfMoney < GameConfig.MONET_MIN_NUMBER) {
            throw new LottoGameException(MoneyException.INVALID_RANGE);
        }
    }

    private void validateUnit(int amountOfMoney) {
        if (amountOfMoney % GameConfig.LOTTO_PRICE_UNIT != 0) {
            throw new LottoGameException(MoneyException.INVALID_UNIT);
        }
    }

    public int getIssueAmount() {
        return amount / GameConfig.LOTTO_PRICE_UNIT;
    }
}
