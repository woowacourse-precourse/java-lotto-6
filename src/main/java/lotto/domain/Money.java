package lotto.domain;

import static lotto.domain.constant.ExceptionMessage.*;
import static lotto.domain.constant.RangeConstant.MAX_MONEY;
import static lotto.domain.constant.RangeConstant.MIN_MONEY;

public class Money {

    private static final int LOTTO_PRICE = 1000;
    private final int purchaseAmount;

    private Money(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public static Money of(String money) {
        includeChar(money);
        int amount = validateRange(money);
        validateUnit(amount);

        return new Money(amount);
    }

    public int getCountBuyLotto() {
        return purchaseAmount / LOTTO_PRICE;
    }

    public double returnOfProfitRate(double totalPrizeMoney) {
        return totalPrizeMoney / purchaseAmount;
    }

    private static void validateUnit(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_UNIT_MONEY.getErrorMessage());
        }
    }

    private static int validateRange(String money) {
        try {
            int amount = Integer.parseInt(money);

            if (amount < MIN_MONEY.getNumber() || amount > MAX_MONEY.getNumber()) {
                throw new IllegalArgumentException(INVALID_RANGE_MONEY.getErrorMessage());
            }

            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_RANGE_MONEY.getErrorMessage());
        }
    }

    private static void includeChar(String money) {
        if (!money.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(INCLUDE_CHAR.getErrorMessage());
        }
    }
}
