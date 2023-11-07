package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoRule;
import lotto.exception.ExceptionMessage;

public class Winning extends LottoRule {
    private List<Integer> numbers;
    private int bonusNumber;

    public Winning() {
    }

    public Winning(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int calcMatchNumberCount(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();

        return numbers.stream()
                .filter(this.numbers::contains)
                .collect(Collectors.toList())
                .size();
    }

    public void validateBonus(int bonusNumber) {
        if (isDuplicateBonusNumber(bonusNumber)) {
            ExceptionMessage.BONUS_NUMBER_DUPLICATE.throwException();
        }
        if (isOutOfRange(bonusNumber)) {
            ExceptionMessage.LOTTO_OUT_OF_RANGE.throwException();
        }
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

    private boolean isDuplicateBonusNumber(int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }


}
