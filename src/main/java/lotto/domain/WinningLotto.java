package lotto.domain;

import java.util.List;
import lotto.validation.Validation;

public class WinningLotto extends Lotto {
    private final int bonus;
    public WinningLotto(List<Integer> numbers, String bonus) {
        super(numbers);
        validate(bonus);
        this.bonus = Integer.parseInt(bonus);
    }

    public int getBonus() {
        return bonus;
    }

    public void validate(final String bonus) {
        Validation.checkIsNumber(bonus);
        Validation.checkIsNatural(Integer.parseInt(bonus));
        Validation.checkNumberIsBetweenStartAndEnd(LottoInfo.START.value, LottoInfo.END.value, Integer.parseInt(bonus));
        Validation.checkLottoNumbersHasBonusNumber(numbers, Integer.parseInt(bonus));
    }
}
