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
        validate(randoms);
        return randoms;
    }

    private static void validate(List<Integer> randoms) {
        if (randoms.size() != LOTTO_COUNT
                || randoms.size() != randoms.stream().distinct().count()) {
            throw new IllegalStateException();
        }

        for (Integer random : randoms) {
            if (!LottoNumbers.contains(random)) {
                throw new IllegalStateException();
            }
        }
    }
}
