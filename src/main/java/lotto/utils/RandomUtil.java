package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.LottoConstant;

public class RandomUtil {

    public static List<Integer> createLottoNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LottoConstant.MIN_VALUE.getValue(),
                LottoConstant.MAX_VALUE.getValue(), LottoConstant.UNIQUE_NUMBERS.getValue());
        return new ArrayList<>(numbers);
    }
}
