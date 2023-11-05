package lotto.model;

import java.util.Collections;
import java.util.List;
import lotto.constant.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        sortAscending(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage
                    .NOT_SIX_NUMBER_ERROR_MESSAGE.getErrorMessage());
        }
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

    private void sortAscending(List<Integer> numbers) {
        Collections.sort(numbers);
    }


}
