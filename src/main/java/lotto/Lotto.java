package lotto;


import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    /**
     * Implementing Restrictions numbers should remain private Can't add *instance* variable
     */
    private static int LOTTO_NUM_MIN = 1;
    private static int LOTTO_NUM_MAX = 45;
    private static int LOTTO_NUM_IN_A_TICKET = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (new HashSet<Integer>(numbers).size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> generateLottoNumbers() {
        return pickUniqueNumbersInRange(LOTTO_NUM_MIN, LOTTO_NUM_MAX, LOTTO_NUM_IN_A_TICKET);
    }

    public int countMatchingNumbers(List<Integer> targetNumbers) {
        return (int)numbers.stream()
                .filter(new HashSet<>(targetNumbers)::contains)
                .count();
    }
    public boolean numbersContain(Integer targetNumber) {
        return numbers.contains(targetNumber);
    }
}
