package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoConstant;

import java.util.List;

public class LottoGenerator implements NumberGenerator {

    @Override
    public List<Integer> create() {
        int start = LottoConstant.START_NUMBER.getValue();
        int end = LottoConstant.END_NUMBER.getValue();
        int count = LottoConstant.COUNT.getValue();
        return Randoms.pickUniqueNumbersInRange(start, end, count);
    }
}