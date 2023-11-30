package lotto.domain;

import java.util.List;
import lotto.validator.LottoNumberValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoNumberValidator.validateLottoNumbers(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int countMatchNumber(Lotto winningLotto) {
        return (int) numbers.stream().
                filter(winningLotto::contains).
                count();
    }

    public boolean checkBonusNumber(int bonusNumber) {
        return (boolean) numbers.contains(bonusNumber);
    }
}
