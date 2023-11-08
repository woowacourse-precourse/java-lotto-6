package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.utils.LottoValidator;

public class Lotto {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NUMBERS_COUNT = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        LottoValidator lottoValidator = new LottoValidator();

        lottoValidator.validateDuplicateNumbers(numbers);
        lottoValidator.validateNumbersCount(numbers);
        lottoValidator.validateNumberRange(numbers);
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
