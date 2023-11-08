package lotto.model;

import java.util.Objects;
import lotto.exception.CanNotConvertToNumberException;
import lotto.exception.InvalidMoneyException;

public class LottoMoney {

    private static final int LOTTO_PRICE = 1_000;
    private static final int PERCENTAGE = 100;
    private static final int ZERO = 0;

    private final long money;

    private LottoMoney(final long money) {
        this.money = money;
    }

    public static LottoMoney createWith(final String money) {
        validateConvertibleToNumber(money);
        long convertedMoney = convertToNumber(money);
        validateOverLottoPrice(convertedMoney);
        validateDivisibleByThousand(convertedMoney);

        return new LottoMoney(convertedMoney);
    }

    private static void validateConvertibleToNumber(final String money) {
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

    private static void validateOverLottoPrice(final long money) {
        if (!isOverLottoPrice(money)) {
            throw new InvalidMoneyException(money);
        }
    }

    private static boolean isOverLottoPrice(final long money) {
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
        return money / LOTTO_PRICE;
    }

    public double calculateProfit(long totalPrize) {
        return ((double) totalPrize / money) * PERCENTAGE;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        LottoMoney lottoMoney1 = (LottoMoney) object;
        return money == lottoMoney1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
