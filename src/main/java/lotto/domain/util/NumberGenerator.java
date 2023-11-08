package lotto.domain.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

import static lotto.domain.constant.LottoConst.COUNT;
import static lotto.domain.constant.LottoConst.HIGHEST_NUMBER;
import static lotto.domain.constant.LottoConst.LOWEST_NUMBER;

public class NumberGenerator {

    public static List<Integer> generateLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(LOWEST_NUMBER, HIGHEST_NUMBER, COUNT);
    }
}
