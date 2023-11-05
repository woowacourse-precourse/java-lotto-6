package lotto.model;

import java.util.Comparator;
import java.util.List;
import lotto.model.validator.LottoNumbersValidator;

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
        numbers.sort(Comparator.naturalOrder());
        return numbers.toString();
    }

    public int countMatchOtherLotto(Lotto otherLotto) {
        otherLotto.numbers.retainAll(numbers);
        return otherLotto.numbers.size();
    }
}
