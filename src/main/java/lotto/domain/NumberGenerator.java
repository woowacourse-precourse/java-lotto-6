package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.domain.constant.LottoNumberConst.LOWEST_NUMBER;
import static lotto.domain.constant.LottoNumberConst.HIGHEST_NUMBER;
import static lotto.domain.constant.LottoNumberConst.COUNT;

public class NumberGenerator {

    public static List<Integer> generateLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(LOWEST_NUMBER, HIGHEST_NUMBER, COUNT);
    }
}
