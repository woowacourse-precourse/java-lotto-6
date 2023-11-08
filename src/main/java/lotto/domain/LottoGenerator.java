package lotto.domain;

import static lotto.util.Util.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGenerator {
    public static List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(START_RANGE, END_RANGE, LOTTO_SIZE);
    }
}
