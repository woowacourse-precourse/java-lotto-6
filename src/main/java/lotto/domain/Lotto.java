package lotto.domain;

import static lotto.utils.constants.ErrorMessageConstants.DUPLICATE_ERROR;
import static lotto.utils.constants.ErrorMessageConstants.ERROR_MESSAGE_HEAD;
import static lotto.utils.constants.ErrorMessageConstants.PICK_NUMBER_ERROR;
import static lotto.utils.constants.ErrorMessageConstants.RANGE_ERROR;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);

        List<Integer> ascendingNumbers = new ArrayList<>(numbers);
        Collections.sort(ascendingNumbers);
        this.numbers = ascendingNumbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEAD + PICK_NUMBER_ERROR);
        }
        if (numbers.stream()
                .distinct()
                .count() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEAD + DUPLICATE_ERROR);
        }
        if (numbers.stream()
                .filter((number) -> number > 45 || number < 1)
                .count() > 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEAD + RANGE_ERROR);
        }
    }
    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean isMatch(int number) {
        return numbers.contains(number);
    }

}
