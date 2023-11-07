package lotto.model;

import static lotto.util.Constant.END_NUMBER;
import static lotto.util.Constant.START_NUMBER;

import java.util.Arrays;
import lotto.util.ExceptionMessage;

public class WinnerLotto {
    Lotto winnerLotto;
    int bonus;

    public WinnerLotto(Lotto winnerLotto, int bonus) {
        this.winnerLotto = winnerLotto;
        validation(bonus);
        this.bonus = bonus;
    }

    private void validation(int bonus) {
        validateRange(bonus);
        validateDuplication(bonus);
    }
    private void validateRange(int bonus) {
        if (isOutOfRange(bonus)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_RANGE.getMessage());
        }
    }

    private boolean isOutOfRange(int bonus) {
        return START_NUMBER > bonus || END_NUMBER < bonus;
    }

    private void validateDuplication(int bonus) {
        if (winnerLotto.contains(bonus)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BONUS_IS_CONTAIN_NUMBERS.getMessage());
        }
    }

    public Rank compare(Lotto lotto) {
        int count = getMatchCount(lotto);
        boolean bonus = lotto.contains(this.bonus);
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.calculateRank(count, bonus))
                .findFirst()
                .orElse(Rank.NONE);
    }

    private int getMatchCount(Lotto lotto) {
        return (int) lotto.getNumbers()
                .stream()
                .filter(winnerLotto::contains)
                .count();
    }
}

