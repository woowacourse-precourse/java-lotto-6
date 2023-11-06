package lotto;

import static lotto.util.Constants.MAX_RANGE;
import static lotto.util.Constants.MIN_RANGE;
import static lotto.util.ErrorConstants.DUPLICATE_NUMBER;
import static lotto.util.ErrorConstants.OVER_RANGE;
import static lotto.util.ErrorConstants.OVER_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    public static void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(OVER_SIZE);
        }
        if (new HashSet<>(numbers).size() != 6) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER);
        }
        for (int number : numbers) {
            if ((number < MIN_RANGE) || (number > MAX_RANGE)) {
                throw new IllegalArgumentException(OVER_RANGE);
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
    
    @Override
    public String toString() {
        return numbers.toString();
    }

}