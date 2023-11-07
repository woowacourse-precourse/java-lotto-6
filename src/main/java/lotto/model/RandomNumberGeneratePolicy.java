package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.constant.LottoConstant;

public class RandomNumberGeneratePolicy {
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(LottoConstant.MIN_NUMBER
                , LottoConstant.MAX_NUMBER
                , LottoConstant.SIZE);
    }
}
