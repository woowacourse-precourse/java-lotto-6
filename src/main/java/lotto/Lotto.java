package lotto;

import static lotto.utils.validator.ErrorMessageConstants.DUPLICATE_ERROR;
import static lotto.utils.validator.ErrorMessageConstants.ERROR_MESSAGE_HEAD;
import static lotto.utils.validator.ErrorMessageConstants.PICK_NUMBER_ERROR;
import static lotto.utils.validator.ErrorMessageConstants.RANGE_ERROR;

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
            throw new IllegalArgumentException(ERROR_MESSAGE_HEAD+PICK_NUMBER_ERROR);
        }
        if (numbers.stream()
                .distinct()
                .count() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEAD+DUPLICATE_ERROR);
        }
    }
    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean isMatch(int number){
        return numbers.contains(number);
    }
}
