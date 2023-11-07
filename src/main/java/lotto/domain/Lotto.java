package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.util.ErrorMessage;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);

        validateNumbersCount(sortedNumbers);
        validateNumbersInRange(sortedNumbers);
        validateDuplicatedNumber(sortedNumbers);

        Collections.sort(sortedNumbers);
        this.numbers = sortedNumbers;
    }

    private void validateNumbersCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(getNumbersCountErrorMessage());
        }
    }

    protected String getNumbersCountErrorMessage() {
        return ErrorMessage.LOTTO_NUMBER_COUNT.getMessage();
    }

    private void validateNumbersInRange(List<Integer> numbers) {
        if (!isNumbersInRange(numbers)) {
            throw new IllegalArgumentException(getNumbersInRangeErrorMessage());
        }
    }

    private boolean isNumbersInRange(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(number ->
                        number >= LottoNumberRule.MIN.number() &&
                                number <= LottoNumberRule.MAX.number()
                );
    }

    protected String getNumbersInRangeErrorMessage() {
        return ErrorMessage.LOTTO_NUMBER_IN_RANGE.getMessage();
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        if (hasDuplicatedNumber(numbers)) {
            throw new IllegalArgumentException(getDuplicatedNumberErrorMessage());
        }
    }

    private boolean hasDuplicatedNumber(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() != numbers.size();
    }

    protected String getDuplicatedNumberErrorMessage() {
        return ErrorMessage.LOTTO_NUMBER_UNIQUE.getMessage();
    }

    protected boolean containsNumber(int number) {
        return this.numbers.contains(number);
    }

    protected List<Integer> getNumbers() {
        return Collections.unmodifiableList(this.numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
