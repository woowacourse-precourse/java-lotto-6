package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.model.Lotto;

public final class LottoGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NUMBER_COUNT = 6;

    private LottoGenerator() {
        // Don't let anyone instantiate this class.
    }

    public static Lotto generate() {
        List<Integer> numbers = generateUniqueNumbers(NUMBER_COUNT);

        return new Lotto(numbers);
    }

    private static List<Integer> generateUniqueNumbers(int count) {
        Set<Integer> numbers = new HashSet<>();

        while (numbers.size() < count) {
            int number = generateNumber();

            numbers.add(number);
        }

        return numbers.stream()
                .toList();
    }

    private static int generateNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
