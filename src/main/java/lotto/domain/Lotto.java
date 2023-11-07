package lotto.domain;

import lotto.Constants;
import lotto.exception.LottoException;

import java.util.List;
// 당첨 번호 6개 입력 + 보너스 번호 입력 후 저장
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
    public void setBonusNumber(int inputBonusNumber) {
        lottoException.validateBonusNumber(numbers, inputBonusNumber);
        numbers.add(inputBonusNumber);
    }
    public List<Integer> getNumbers() {
        return numbers;
    }
    public int getBonusNumber() {
        return numbers.get(Constants.BONUS_INDEX);
    }
}



