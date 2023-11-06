package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.model.constant.LottoConfig.*;

public class NumbersGenerator {

    public static List<Integer> lottoNumbersGenerator() {
        return Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER,MAXIMUM_LOTTO_NUMBER,LOTTO_SIZE);
    }
}
