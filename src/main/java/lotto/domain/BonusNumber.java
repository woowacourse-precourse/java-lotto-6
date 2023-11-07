package lotto.domain;

import java.util.List;
import lotto.util.validator.LottoNumberValidator;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number) {
        this.number = number;
    }

    public static BonusNumber from(int bonusNumber, List<Integer> numbers) {
        LottoNumberValidator.validateBonusNumber(bonusNumber, numbers);
        return new BonusNumber(bonusNumber);
    }

    public int getNumber() {
        return number;
    }
}
