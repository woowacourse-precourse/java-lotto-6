package lotto;

import java.util.List;

public class Bonus {
    private int number;

    Bonus (int number) {
        validate(number);
        this.number = number;
    }

    void validate(int number) {
        if (!(Lotto.isBetweenTwoNumbers(List.of(number), Lotto.START_NUMBER, Lotto.END_NUMBER))) {
            throw new IllegalArgumentException();
        }
    }
}
