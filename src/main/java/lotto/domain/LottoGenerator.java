package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoGenerator {
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(ConstNum.LOTTO_MIN.getNum(),
                ConstNum.LOTTO_MAX.getNum(),
                ConstNum.LENGTH.getNum());
    }
}
