package lotto.domain;

import lotto.view.input.error.InputError;
import lotto.view.input.error.InputIllegalArgumentException;

public class Money {

    private static final int ESSENTIAL_RESULT = 0;
    private static final int LOTTERY_PRICE = 1000;

    private final long money;
    private final long lotteryCount;

    private static Money moneyInstance;

    private Money(long money, long lotteryCount) {
        this.money = money;
        this.lotteryCount = lotteryCount;
    }

    public static Money getInstance(long amount) {
        if (moneyInstance == null) {
            validateMoney(amount);
            return new Money(amount, amount / LOTTERY_PRICE);
        }
        return moneyInstance;
    }

    public long getLotteryCount() {
        return this.lotteryCount;
    }

    private static void validateMoney(long amount) {

        if (isNotPositiveAmount(amount)) {
            throw new InputIllegalArgumentException(InputError.MUST_POSITIVE_AMOUNT_MONEY);
        }

        if (canNotPurchase(LOTTERY_PRICE, amount)) {
            throw new InputIllegalArgumentException(InputError.NOT_DIVISIBLE_BY_PRICE);
        }
    }

    private static boolean isNotPositiveAmount(long amount) {
        return amount < ESSENTIAL_RESULT;
    }


    private static boolean canNotPurchase(int price, long amount) {
        return amount % price != ESSENTIAL_RESULT;
    }

}
