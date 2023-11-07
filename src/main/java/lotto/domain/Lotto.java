package lotto.domain;

import lotto.constant.Error;
import lotto.controller.Setting;
import lotto.exception.LottoException;

import java.util.List;

public class Lotto {

    private Setting setting = Setting.getSetting();
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        manageException(numbers);
        this.numbers = numbers;
    }

    public List<Integer> returnFarsighted(){
        return numbers;
    }

    private void manageException(List<Integer> numbers) {
        try {
            validateSize(numbers);
            validateDuplication(numbers);
            validateRange(numbers);
        } catch (IllegalArgumentException e) {
            setting.pickJackpot();
        }

    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            new LottoException(Error.INVALID_NUMBER_COUNT);
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (isDuplication(numbers)) {
            new LottoException(Error.DUPLICATED_NUMBER);
        }

    }

    protected boolean isDuplication(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() != numbers.size();
    }

    private void validateRange(List<Integer> numbers) {
        if (!checkRange(numbers)) {
            new LottoException(Error.INVALID_RANGE);
        }
    }

    private boolean checkRange(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(num -> num >= 1 && num <= 45);
    }

}
