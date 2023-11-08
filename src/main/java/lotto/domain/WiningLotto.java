package lotto.domain;

import static lotto.config.SystemNumberConfig.RANDOM_END;
import static lotto.config.SystemNumberConfig.RANDOM_START;
import static lotto.message.ErrorMessage.DUPLICATION_BONUS;
import static lotto.message.ErrorMessage.NUMBER_RANGE;

import java.util.List;

public class WiningLotto {
    private final Lotto winNumber;
    private final int bonus;


    public WiningLotto(Lotto winNumber, int bonus) {
        validate(winNumber, bonus);
        this.winNumber = winNumber;
        this.bonus = bonus;
    }

    private void validate(Lotto winNumber, int bonus) {
        validateRange(bonus);
        validateBonusDuplication(winNumber, bonus);
    }

    private void validateRange(int bonus) {
        if (bonus < RANDOM_START.getConfig() || bonus > RANDOM_END.getConfig()) {
            throw new IllegalArgumentException(NUMBER_RANGE.getErrorMessage());
        }
    }

    private void validateBonusDuplication(Lotto winNumber, int bonus) {
        if (winNumber.getNumbers().contains(bonus)) {
            throw new IllegalArgumentException(DUPLICATION_BONUS.getErrorMessage());
        }
    }

    public List<Integer> getWinNumber() {
        return winNumber.getNumbers();
    }

    public int getBonus() {
        return bonus;
    }


}
