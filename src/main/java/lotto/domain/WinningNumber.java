package lotto.domain;

import lotto.config.LottoConfig;
import lotto.config.WinningPrize;

public class WinningNumber {
    private static final int RANGE_START = LottoConfig.RANGE_START.getValue();
    private static final int RANGE_END = LottoConfig.RANGE_END.getValue();

    private final Lotto numbers;
    private final int bonus;

    public WinningNumber(Lotto numbers, int bonus) {
        validateRange(bonus);
        validateDuplicates(numbers, bonus);
        this.numbers = numbers;
        this.bonus = bonus;
    }

    public WinningPrize compareWithLotto(Lotto target) {
        return target.compareWithAnswer(numbers, bonus);
    }

    private void validateRange(int number) {
        if (number < RANGE_START || number > RANGE_END) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicates(Lotto numbers, int bonus) {
        if (numbers.checkDuplicates(bonus)) {
            throw new IllegalArgumentException();
        }
    }
}
