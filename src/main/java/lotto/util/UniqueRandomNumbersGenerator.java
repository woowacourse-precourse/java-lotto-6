package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.constant.LottoConstant.RANGE_START_NUMBER;
import static lotto.constant.LottoConstant.RANGE_END_NUMBER;
import static lotto.constant.LottoConstant.LOTTO_LENGTH;


public class UniqueRandomNumbersGenerator implements NumberGenerator {
    @Override
    public List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(RANGE_START_NUMBER.getSetting(),
                                                RANGE_END_NUMBER.getSetting(),
                                                LOTTO_LENGTH.getSetting()
        );
    }

}
