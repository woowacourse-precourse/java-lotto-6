package lotto.domain;

import java.util.List;
import lotto.validation.Validation;
import lotto.view.OutputView;

public class WinningLotto extends Lotto {
    private final int bonus;
    public WinningLotto(List<Integer> numbers, String bonus) {
        super(numbers);
        validate(bonus);
        this.bonus = Integer.parseInt(bonus);
    }

    public void validate(final String bonus) {
        Validation.checkIsNumber(bonus);
        Validation.checkIsNatural(Integer.parseInt(bonus));
        Validation.checkNumberIsBetweenStartAndEnd(START, END, Integer.parseInt(bonus));
        Validation.checkLottoNumbersHasBonusNumber(numbers, Integer.parseInt(bonus));
    }
}
