package lotto.domain;

import lotto.constant.Error;
import lotto.controller.Setting;
import lotto.exception.LottoException;

import java.util.List;

public class Jackpot extends Lotto {

    private int bonus;

    public Jackpot(List<Integer> numbers, int bonus) {
        super(numbers);
        manageException(numbers, bonus);
        this.bonus = bonus;
    }

    public int returnBonusValue() {
        return bonus;
    }

    private void manageException(List<Integer> numbers, int bonus) {
        validateDuplicationOfBonus(numbers, bonus);
    }

    private void validateDuplicationOfBonus(List<Integer> numbers, int bonus) {
        numbers.add(bonus);

        if (super.isDuplication(numbers)) {
            throw new LottoException(Error.DUPLICATED_BONUS_NUMBER);
        }
    }

}
