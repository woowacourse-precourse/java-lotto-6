package lotto;

import java.util.List;
import lotto.model.Constants;
import lotto.model.PRIZE_TYPE;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public PRIZE_TYPE calculatePrize(Lotto prizeNumber, int bonusNumber) {
        final int FIRST_PRIZE_CONTAIN_COUNT = 6;
        final int THIRD_PRIZE_CONTAIN_COUNT = 5;
        int containCount = 0;
        for (int value : prizeNumber.numbers) {
            if (numbers.contains(value)) {
                containCount++;
            }
        }

        if (containCount == FIRST_PRIZE_CONTAIN_COUNT) {
            containCount++;
        }

        if (containCount == THIRD_PRIZE_CONTAIN_COUNT &&
                numbers.contains(bonusNumber)) {
            containCount++;
        }

        return Constants.PRIZE_CONDITION.get(containCount);
    }

}
