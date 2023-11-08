package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.utils.LottoValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        LottoValidator lottoValidator = new LottoValidator();

        lottoValidator.validateDuplicateNumbers(numbers);
        lottoValidator.validateNumbersCount(numbers);
        lottoValidator.validateNumbersRange(numbers);
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
