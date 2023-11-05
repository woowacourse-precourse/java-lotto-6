package lotto.domain;

import lotto.config.ErrorMessage;
import lotto.config.LottoConfig;
import lotto.config.WinningPrize;

public class WinningNumber {
    private static final int RANGE_START = LottoConfig.RANGE_START.value();
    private static final int RANGE_END = LottoConfig.RANGE_END.value();

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
            throw new IllegalArgumentException(ErrorMessage.WRONG_BONUS_RANGE.message());
        }
    }

    private void validateDuplicates(Lotto numbers, int bonus) {
        if (numbers.checkDuplicates(bonus)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_BONUS.message());
        }
    }
}
