package domain;

import static util.ErrorMessage.AMOUNT_MUST_BE_DIVIDED_BY_PRICE;
import static util.ErrorMessage.AMOUNT_MUST_POSITIVE;
import static util.LottoValidationValue.LOTTO_PRICE;

public class Amount {
    private final int amount;

    public Amount(int amount) {
        this.amount = validate(amount);
    }

    public int getAmount() {
        return this.amount;
    }

    private int validate(int amount) {
        if (!checkIsPositive(amount)) {
            return 0;
        }
        if (!checkDividedByPrice(amount)) {
            return 0;
        }
        return amount / LOTTO_PRICE.get();
    }

    private boolean checkIsPositive(int amount) {
        try {
            if (amount < 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(AMOUNT_MUST_POSITIVE.get());
            return false;
        }
        return true;
    }

    private boolean checkDividedByPrice(int amount) {
        try {
            if (amount % LOTTO_PRICE.get() != 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(AMOUNT_MUST_BE_DIVIDED_BY_PRICE.get());
            return false;
        }
        return true;
    }

    public boolean isValid() {
        return this.amount != 0;
    }

    public void printAmount() {
        System.out.print(this.amount);
    }

    public boolean isLargerThen(int number) {
        return this.amount > number;
    }
}
