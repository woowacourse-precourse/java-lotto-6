package lotto;

import lotto.utils.ErrorMessage;

import java.util.Objects;

public class Bonus {

    private final int number;

    private Bonus(int number) {
        this.number = number;
    }


    public static Bonus of(int number) {
        validate(number);
        return new Bonus(number);
    }

    private static void validate(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage());
        }
    }

    public static Bonus ofAndCheckDuplicatedNumber(Lotto lotto, int number) {
        lotto.checkDuplicatedNumber(number);
        return of(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bonus bonus = (Bonus) o;
        return number == bonus.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
