package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.enums.LottoEnum;

import java.util.List;

public class LottoNumbersGenerator {
    public static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(LottoEnum.MIN_LOTTO_NUMBER.getValue(), LottoEnum.MAX_LOTTO_NUMBER.getValue(), LottoEnum.SELECTED_NUMBERS_SIZE.getValue());
    }
}
