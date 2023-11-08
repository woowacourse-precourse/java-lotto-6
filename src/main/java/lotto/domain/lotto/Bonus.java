package lotto.domain.lotto;

import java.util.Objects;

import static lotto.utils.LottoUtils.validateNumber;

public final class Bonus {

    private final int number;

    private Bonus(int number) {
        this.number = number;
    }


    public static Bonus of(int number) {
        validateNumber(number);
        return new Bonus(number);
    }

    public int matchingNumber(Lotto lotto) {
        if (lotto.isMatchedNumber(number)) {
            return 1;
        }
        return 0;
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
