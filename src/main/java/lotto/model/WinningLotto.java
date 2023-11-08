package lotto.model;

import lotto.Lotto;
import lotto.model.enums.LottoSpec;
import lotto.view.enums.ErrorMessage;

import java.util.HashSet;
import java.util.List;

public class WinningLotto extends Lotto {
    private int bonus;

    public WinningLotto(List<Integer> numbers, int bonus) {
        super(numbers);
        validateBonus(numbers, bonus);
        this.bonus = bonus;
    }

    private void validateBonus(List<Integer> numbers, int bonus) {
        validateBonusInRange(bonus);
        validateBonusDuplicate(numbers, bonus);
    }

    public int getBonus() {
        return bonus;
    }

    private void validateBonusInRange(int bonus) {
        if (bonus < LottoSpec.MIN_NUMBER.getValue() || bonus > LottoSpec.MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    private void validateBonusDuplicate(List<Integer> numbers, int bonus) {
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATED.getMessage());
        }
    }

    @Override
    protected void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_WRONG_SIZE.getMessage());
        }
    }

    @Override
    protected void validateNumberInRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LottoSpec.MIN_NUMBER.getValue() || number > LottoSpec.MAX_NUMBER.getValue()) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
            }
        }
    }

    @Override
    protected void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != 6) {
            throw new IllegalStateException(ErrorMessage.WINNING_NUMBER_DUPLICATED.getMessage());
        }
    }
}
