package lotto;

import java.lang.invoke.VarHandle;
import java.util.List;

public class WinningNumbers {

    private final Lotto lotto;
    private final Integer bonus;

    public WinningNumbers(List<Integer> numbers, Integer bonus) {
        lotto = new Lotto(numbers);
        validate(bonus);
        this.bonus = bonus;
    }

    private void validate(Integer bonus) {
        if (lotto.contains(bonus)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_AND_BONUS_DUPLICATED_MESSAGE);
        }
    }
}
