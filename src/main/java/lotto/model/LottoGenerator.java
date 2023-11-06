package lotto.model;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.Collections;
import java.util.List;
import lotto.util.ErrorCode;

public class LottoGenerator {
    private static final int SIZE = 6;
    private static final int ONCE = 1;
    private static final int MIN = 1;
    private static final int MAX = 45;

    public static Lotto generateRandomLotto() {
        List<Integer> randomlyPicked = pickUniqueNumbersInRange(MIN, MAX, SIZE);
        return new Lotto(randomlyPicked.stream().sorted().toList());
    }

    public static Lotto generateAnswerLotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
        return new Lotto(numbers.stream().sorted().toList());
    }


    private static void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().anyMatch(i -> Collections.frequency(numbers, i) > ONCE)) {
            throw new IllegalArgumentException(ErrorCode.LOTTO_DUPLICATED.getMessage());
        }
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException(ErrorCode.LOTTO_SIZE.getMessage());
        }
    }

    private static void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(i -> i < MIN || i > MAX)) {
            throw new IllegalArgumentException(ErrorCode.LOTTO_ILLEGAL_NUMBER.getMessage());
        }
    }
}
