package lotto.Model;

import java.util.List;

public class BonusNumber {
    private static final int MIN_NUMBER =1;
    private static final int MAX_NUMBER = 45;
    private final int bonusNumber;

    public BonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        this.bonusNumber = bonusNumber;
        numberRangeCheck(bonusNumber);
        numberLengthCheck(winningNumbers);

    }

    private void numberLengthCheck(List<Integer> numbers){
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_BONUS_DUPLICATION.getErrorMessage());
        }
    }
    private void numberRangeCheck(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_RANGE.getErrorMessage());
        }
    }
}
