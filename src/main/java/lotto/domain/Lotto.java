package lotto.domain;

import lotto.constant.Error;
import lotto.controller.Setting;
import lotto.exception.LottoException;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private Setting setting;

    public Lotto(List<Integer> numbers) {
        manageException(numbers);
        this.numbers = numbers;
    }

    private void manageException(List<Integer> numbers) {
        try {
            validateSize(numbers);
            validateDuplication(numbers);
        } catch (IllegalArgumentException e){

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

}
