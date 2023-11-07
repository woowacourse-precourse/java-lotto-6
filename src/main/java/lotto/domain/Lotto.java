package lotto.domain;

import lotto.exception.InvalidLottoException;

import java.util.List;


public class Lotto {
    private final InvalidLottoException invalidLottoException = new InvalidLottoException();
    private final static int BONUS_INDEX = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    public void validateNumbers(List<Integer> numbers) {
        invalidLottoException.validateLottoNumbers(numbers);
    }

    public void setBonusNumber(int inputBonusNumber) {
        invalidLottoException.validateBonusNumbers(numbers, inputBonusNumber);
        numbers.add(inputBonusNumber);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return numbers.get(BONUS_INDEX);
    }
}
