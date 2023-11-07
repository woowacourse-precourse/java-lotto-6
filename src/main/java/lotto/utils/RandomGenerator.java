package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.enums.LottoNumbers;

import java.util.List;

public class RandomGenerator {
    private static final int LOTTO_START_NUMBER = LottoNumbers.getStart(),
            LOTTO_END_NUMBER = LottoNumbers.getEnd(),
            LOTTO_COUNT = Lotto.getNumbersSize();

    private RandomGenerator() {

    }

    public static List<Integer> generate() {
        List<Integer> randoms = Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_COUNT);

        validateSize(randoms);
        validateDuplicate(randoms);
        validateNumbers(randoms);

        return randoms;
    }

    private static void validateSize(List<Integer> randoms) {
        if (randoms.size() != LOTTO_COUNT) {
            throw new IllegalStateException();
        }
    }

    private static void validateDuplicate(List<Integer> randoms) {
        if (randoms.size() != randoms.stream().distinct().count()) {
            throw new IllegalStateException();
        }
    }

    private static void validateNumbers(List<Integer> randoms) {
        if (!randoms.stream().allMatch(LottoNumbers::contains)) {
            throw new IllegalStateException();
        }
    }
}
