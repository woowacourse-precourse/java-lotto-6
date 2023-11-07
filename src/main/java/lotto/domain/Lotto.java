package lotto.domain;

import lotto.exception.LottoException;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private final LottoException lottoException = new LottoException();

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        lottoException.validateLottoNumbers(numbers);
    }
    public void setBonusNumber(int bonusNumber) {
        lottoException.validateBonusNumber(numbers, bonusNumber);
    }
    public List<Integer> getNumbers(){
        return numbers;
    }

}



