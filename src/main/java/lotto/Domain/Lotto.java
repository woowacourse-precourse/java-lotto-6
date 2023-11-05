package lotto.Domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private final static LottoNumberException lottoNumberException = new LottoNumberException();
    private final static BonusNumberException bonusNumberException = new BonusNumberException();
    private final static int BONUS_NUMBER_POSITION = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        lottoNumberException.validateLottoNumbers(numbers);
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

    public void setBonusNumber(int inputBonusNumber) {
        bonusNumberException.validateBonusNumber(numbers, inputBonusNumber);
        numbers.add(inputBonusNumber);
    }

    public int getBonusNumber() {
        return numbers.get(BONUS_NUMBER_POSITION);
    }
}
