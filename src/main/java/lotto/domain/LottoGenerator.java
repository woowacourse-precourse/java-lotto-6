package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoGenerator {
    private Integer MINIMUM=1;
    private Integer MAXIMUM=45;
    private Integer SIZE=6;

    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(MINIMUM, MAXIMUM, SIZE);
    }
}
