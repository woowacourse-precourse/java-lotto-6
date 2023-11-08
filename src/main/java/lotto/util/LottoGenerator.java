package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.constant.LottoGameNumber;
import lotto.model.Lotto;

public final class LottoGenerator {
    private LottoGenerator() {
        // Don't let anyone instantiate this class.
    }

    public static Lotto generate() {
        List<Integer> numbers = generateUniqueNumbers();

        return new Lotto(numbers);
    }

    private static List<Integer> generateUniqueNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoGameNumber.MINIMUM, LottoGameNumber.MAXIMUM,
                LottoGameNumber.COUNT);
    }
}
