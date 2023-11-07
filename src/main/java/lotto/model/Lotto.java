package lotto.model;

import java.util.List;
import lotto.util.validator.LottoNumbersValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoNumbersValidator.validateLottoNumbersSize(numbers);
        LottoNumbersValidator.validateDuplicatedLottoNumbers(numbers);
        this.numbers = numbers;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public String showNumbers() {
        return numbers.stream().sorted().toList().toString();
    }

    public int countMatchOtherLotto(Lotto otherLotto) {
        return (int) numbers.stream()
                .filter(otherLotto.numbers::contains)
                .count();
    }
}
