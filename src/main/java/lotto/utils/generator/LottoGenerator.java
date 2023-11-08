package lotto.utils.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.Collectors;
import lotto.domain.Lotto;

public class LottoGenerator {
    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 45;
    public static final int LOTTO_COUNT = 6;

    public static Lotto generate() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, LOTTO_COUNT));
    }
}
