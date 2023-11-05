package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.enums.LottoNumbers;

import java.util.List;

public class RandomGenerator {
    private static final int START = LottoNumbers.getStart(),
            END = LottoNumbers.getEnd(),
            COUNT = Lotto.getNumbersSize();

    private RandomGenerator() {

    }

    public static List<Integer> generate() {
        List<Integer> randoms = Randoms.pickUniqueNumbersInRange(START, END, COUNT);
        validate(randoms);
        return randoms;
    }

    private static void validate(List<Integer> randoms) {
        if (randoms.size() != COUNT
                || randoms.size() != randoms.stream().distinct().count()) {
            throw new IllegalStateException();
        }

        for(Integer random : randoms) {
            if (!LottoNumbers.contains(random)) {
                throw new IllegalStateException();
            }
        }
    }
}
