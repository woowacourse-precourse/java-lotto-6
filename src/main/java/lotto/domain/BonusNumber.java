package lotto.domain;


import java.util.List;

import static lotto.ErrorMessage.NOT_COMPOSED_OF_UNIQUE_NUMBERS;
import static lotto.Validator.validateNumberInRange;

public class BonusNumber {
    private int bonusNumber;

    public BonusNumber(int bonusNumber){
        validateNumberInRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public void validateDuplicateNumbers(List<Integer> winningNumbers){
        if(winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(NOT_COMPOSED_OF_UNIQUE_NUMBERS);
        }
    }


    public boolean isMatchingBonusNumber(List<Integer> numbers) {
        return numbers.contains(bonusNumber);
    }
}
