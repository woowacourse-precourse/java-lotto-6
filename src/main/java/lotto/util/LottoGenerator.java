package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.LottoNumber;
import lotto.model.Lotto;

public final class LottoGenerator {
    private LottoGenerator() {
        // Don't let anyone instantiate this class.
    }

    public static Lotto generate() {
        List<Integer> numbers = generateUniqueNumbers(LottoNumber.COUNT);

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
        return Randoms.pickNumberInRange(LottoNumber.MINIMUM, LottoNumber.MAXIMUM);
    }
}
