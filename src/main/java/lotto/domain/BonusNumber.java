package lotto.domain;

import java.util.List;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number) {
        this.number = number;
    }

    boolean matches(List<Integer> numbers) {
        return numbers.contains(number);
    }
}
