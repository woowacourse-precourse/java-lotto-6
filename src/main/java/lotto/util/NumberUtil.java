package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.constant.LottoNumber;

public class NumberUtil {
    public List<Integer> getLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                LottoNumber.FIRST_NUMBER.getNumber(),
                LottoNumber.LAST_NUMBER.getNumber(),
                LottoNumber.MAX_COUNT.getNumber());
    }
}