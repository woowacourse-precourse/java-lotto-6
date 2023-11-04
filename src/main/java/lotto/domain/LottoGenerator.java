package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.config.ConstNum;

import java.util.List;

public class LottoGenerator {
    public List<Integer> generate() {
        Integer min = ConstNum.LOTTO_MIN.getNum();
        Integer max = ConstNum.LOTTO_MAX.getNum();
        Integer length = ConstNum.LENGTH.getNum();

        return Randoms.pickUniqueNumbersInRange(min, max, length)
                .stream()
                .sorted()
                .toList();
    }
}
