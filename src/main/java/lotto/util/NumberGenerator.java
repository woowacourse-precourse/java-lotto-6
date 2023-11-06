package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.LottoConstant;

public class NumberGenerator {
    public static List<Integer> generate() {
        return new ArrayList(Randoms.pickUniqueNumbersInRange(LottoConstant.LOTTO_MIN_NUMBER,
                LottoConstant.LOTTO_MAX_NUMBER,
                LottoConstant.LOTTO_LENGTH));
    }
}
