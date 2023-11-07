package lotto.domain;

import lotto.constant.Error;
import lotto.exception.LottoException;

import java.util.List;

public class Jackpot extends Lotto{

    private int bonus;

    public Jackpot(List<Integer> numbers, int bonus) {
        super(numbers);
        manageException(numbers, bonus);
        this.bonus = bonus;
    }

    private void manageException(List<Integer> numbers, int bonus) {
        validateDuplicationOfBonus(numbers, bonus);
    }

    private void validateDuplicationOfBonus(List<Integer> numbers, int bonus) {
        numbers.add(bonus);

        if(super.isDuplication(numbers)) {
            new LottoException(Error.DUPLICATED_BONUS_NUMBER);
        }
    }
}
