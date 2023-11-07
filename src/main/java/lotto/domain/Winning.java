package lotto.domain;

import java.util.List;
import lotto.exception.ExceptionMessage;

public class Winning extends LottoRule {
    private List<Integer> numbers;
    private int bonusNumber;

    public void validateBonus(int bonusNumber) {
        if (isDuplicateBonusNumber(bonusNumber)) {
            ExceptionMessage.BONUS_NUMBER_DUPLICATE.throwException();
        }
        if (isOutOfRange(bonusNumber)){
            ExceptionMessage.LOTTO_OUT_OF_RANGE.throwException();
        }
    }

    private boolean isDuplicateBonusNumber(int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setNumbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public void setBonusNumber(int bonusNumber) {
        validateBonus(bonusNumber);
        this.bonusNumber = bonusNumber;
    }
}
