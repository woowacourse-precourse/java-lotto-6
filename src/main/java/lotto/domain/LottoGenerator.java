package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LottoGenerator {
    public Lotto generate() {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        lotto.sort(Comparator.naturalOrder());
        return new Lotto(lotto);
    }
}
