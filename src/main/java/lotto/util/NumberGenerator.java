package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.LottoConstant;
import lotto.constant.NumberRange;

public class NumberGenerator {
    public static List<Integer> generate() {
        return new ArrayList(Randoms.pickUniqueNumbersInRange(NumberRange.MIN.getNumber(),
                NumberRange.MAX.getNumber(), LottoConstant.LOTTO_LENGTH));
    }
}
