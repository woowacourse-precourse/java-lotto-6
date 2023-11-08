package lotto.domain.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.constant.LottoConstant;

public class RandomNumber {
    public static List<Integer> gernerate() {
        return Randoms.pickUniqueNumbersInRange(LottoConstant.LOTTO_START_NUMBER,
                LottoConstant.LOTTO_END_NUMBER, LottoConstant.LOTTO_PICK_NUMBER);
    }

}
