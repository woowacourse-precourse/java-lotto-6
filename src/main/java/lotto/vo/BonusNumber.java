package lotto.vo;

import java.util.List;

public final class BonusNumber {
    private final int number;

    private BonusNumber(int number) {
        this.number = number;
    }

    public static BonusNumber from(int number) {
        return new BonusNumber(number);
    }

    public boolean isContainedIn(List<Integer> numbers) {
        return numbers.contains(number);
    }
}
