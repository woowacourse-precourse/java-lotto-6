package lotto;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.ErrorMessage.INVALID_NUMBERS_SIZE;
import static lotto.ErrorMessage.NUMBERS_DUPLICATE;

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
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_NUMBERS_SIZE.getMessage());
        }
        else if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException(NUMBERS_DUPLICATE.getMessage());
        }
    }

    public static Lotto generate() {
        return new Lotto(
                pickUniqueNumbersInRange(
                        1,
                        45,
                        6
                )
        );
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
