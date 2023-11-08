package lotto.domain;

import java.util.List;

import lotto.exception.LottoException;

public class Lotto {

    private final static int BONUS_INDEX = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoException lottoException = new LottoException();
        lottoException.validateLottoNumbers(numbers);
    }

    public void setBonusNumber(int inputBonusNumber) {
        LottoException lottoException = new LottoException();
        lottoException.validateBonusNumbers(numbers, inputBonusNumber);
        numbers.add(inputBonusNumber);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return numbers.get(BONUS_INDEX);
    }
}
