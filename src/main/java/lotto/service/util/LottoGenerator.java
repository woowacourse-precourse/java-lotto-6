package lotto.service.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.constant.LottoConstant;
import lotto.domain.Lotto;

public class LottoGenerator {
    private LottoGenerator() {
    }

    public static Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LottoConstant.LOTTO_MIN_NUM.getValue(),
                LottoConstant.LOTTO_MAX_NUM.getValue(), LottoConstant.LOTTO_ITEM_COUNT.getValue());
        return Lotto.from(numbers);
    }
}