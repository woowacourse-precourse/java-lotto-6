package lotto.model;

import java.util.Objects;
import lotto.exception.CanNotConvertToNumberException;
import lotto.exception.InvalidMoneyException;

public class Money {

    private static final int LOTTO_PRICE = 1_000;
    private static final int PERCENTAGE = 100;
    private static final int ZERO = 0;

    private final long lottoMoney;

    private Money(final long lottoMoney) {
        this.lottoMoney = lottoMoney;
    }

    public static Money createWith(final String money) {
        validateConvertibleToNumber(money);
        long convertedMoney = convertToNumber(money);
        validateOverThousand(convertedMoney);
        validateDivisibleByThousand(convertedMoney);

        return new Money(convertedMoney);
    }

    public static void validateConvertibleToNumber(final String money) {
        if (!isNumeric(money)) {
            throw new CanNotConvertToNumberException(money);
        }
    }

    private static boolean isNumeric(final String money) {

        return money.chars()
                .allMatch(Character::isDigit);
    }

    private static long convertToNumber(final String money) {
        return Long.parseLong(money);
    }

    private static void validateOverThousand(final long money) {
        if (!isOverThousand(money)) {
            throw new InvalidMoneyException(money);
        }
    }

    private static boolean isOverThousand(final long money) {
        return money >= LOTTO_PRICE;
    }

    private static void validateDivisibleByThousand(final long money) {
        if (!canDivideByThousand(money)) {
            throw new InvalidMoneyException(money);
        }
    }

    private static boolean canDivideByThousand(final long money) {
        return money % LOTTO_PRICE == ZERO;
    }


    public long calculateTicketCount() {
        return lottoMoney / LOTTO_PRICE;
    }

    public double calculateProfit(long totalProfit) {
        return ((double) totalProfit / lottoMoney) * PERCENTAGE;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Money money1 = (Money) object;
        return lottoMoney == money1.lottoMoney;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoMoney);
    }
}
