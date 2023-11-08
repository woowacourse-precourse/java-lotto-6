package util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoNumberGenerator {
    private LottoNumberGenerator() {
    }

    public static List<Integer> generate(final int MIN_LOTTO_NUMBER, final int MAX_LOTTO_NUMBER, final int NUMBER_OF_LOTTO_NUMBERS) {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, NUMBER_OF_LOTTO_NUMBERS);
    }
}
