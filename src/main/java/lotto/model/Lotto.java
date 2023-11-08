package lotto.model;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.Constant.*;
import static lotto.ErrorMessage.INVALID_NUMBER_SIZE;
import static lotto.ErrorMessage.NUMBER_DUPLICATE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != MAX_NUMBER_SIZE) {
            throw new IllegalArgumentException(INVALID_NUMBER_SIZE.getMessage());
        }
        else if (numbers.stream().distinct().count() != MAX_NUMBER_SIZE) {
            throw new IllegalArgumentException(NUMBER_DUPLICATE.getMessage());
        }
    }

    public static Lotto generate() {
        return new Lotto(
                pickUniqueNumbersInRange(
                        LOTTO_MIN_VALUE,
                        LOTTO_MAX_VALUE,
                        MAX_NUMBER_SIZE
                )
        );
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
