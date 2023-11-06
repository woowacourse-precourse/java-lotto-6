package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.model.constant.LottoConfig.*;

public class LottoGenerator {

    public static List<Integer> lottoGenerator() {
        return Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER,MAXIMUM_LOTTO_NUMBER,LOTTO_SIZE);
    }
}
