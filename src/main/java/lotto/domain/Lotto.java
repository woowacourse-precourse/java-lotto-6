package lotto.domain;

import lotto.constant.Error;
import lotto.controller.Setting;
import lotto.exception.LottoException;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        manageException(numbers);
        this.numbers = numbers;
    }

    public List<Integer> returnFarsighted(){
        return numbers;
    }

    private void manageException(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        validateRange(numbers);

    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new LottoException(Error.INVALID_NUMBER_COUNT);
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (isDuplication(numbers)) {
            throw new LottoException(Error.DUPLICATED_NUMBER);
        }

    }

    protected boolean isDuplication(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() != numbers.size();
    }

    private void validateRange(List<Integer> numbers) {
        if (!checkRange(numbers)) {
            throw new LottoException(Error.INVALID_RANGE);
        }
    }

    private boolean checkRange(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(num -> num >= 1 && num <= 45);
    }

}
