package lotto.model;

import static lotto.exception.ExceptionMessage.MESSAGE_LIMIT_MONEY;
import static lotto.exception.ExceptionMessage.MESSAGE_THOUSAND_UNIT;
import static lotto.utils.Constants.LIMIT_MONEY;
import static lotto.utils.Constants.LOTTO_PRICE;
import static lotto.utils.Constants.REMAINDER_ZERO;

import lotto.exception.ClientException;

public class LottoMoney {
    private final int money;

    public LottoMoney(final int money) {
        validation(money);
        this.money = money;
    }

    private void validation(int money) {
        validateThousandUnit(money);
        validateLimit(money);
    }

    private void validateThousandUnit(int money) {
        if (money % LOTTO_PRICE > REMAINDER_ZERO) {
            throw new ClientException(MESSAGE_THOUSAND_UNIT);
        }
    }

    private void validateLimit(int money) {
        if (money > LIMIT_MONEY) {
            throw new ClientException(MESSAGE_LIMIT_MONEY);
        }
    }

    public int calculateCountLottoPrice() {
        return money / LOTTO_PRICE;
    }
}
