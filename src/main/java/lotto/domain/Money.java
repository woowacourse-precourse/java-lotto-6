package lotto.domain;

import lotto.exception.DivideByLottoPriceException;
import lotto.exception.EmptyStringException;
import lotto.exception.InvalidNumberFormatException;

public class Money {
    private static final Integer LOTTO_PRICE = 1000;
    Integer money;

    public Money(Integer money) {

        validateNull(money);
        validateNumberScope(money);
        validateDivideByThousand(money);

        this.money = money;
    }

    private void validateNull(Integer money) {
        if (isNull(money)) {
            throw new EmptyStringException();
        }
    }

    private void validateNumberScope(Integer money) {
        if (!isPositiveNumber(money)) {
            throw new InvalidNumberFormatException();
        }
    }

    private void validateDivideByThousand(Integer money) {
        if (!canDivideByLottoPrice(money)) {
            throw new DivideByLottoPriceException();
        }
    }

    private static boolean isNull(Integer amount) {
        return (amount == null);
    }

    private static boolean isPositiveNumber(Integer amount) {
        return (amount > 0);
    }

    private static boolean canDivideByLottoPrice(Integer amount) {
        return (amount % LOTTO_PRICE == 0);
    }

    public Integer getMoney() {
        return money;
    }
}
