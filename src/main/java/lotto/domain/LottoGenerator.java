package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.Comparator;

public class LottoGenerator {
    public static Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LottoNumberConstant.MIN.getValue(), LottoNumberConstant.MAX.getValue(), LottoNumberConstant.COUNT.getValue());
        List<Integer> temp = new ArrayList<>(numbers);
        temp.sort(Comparator.naturalOrder());
        Lotto lotto = new Lotto(temp);
        return lotto;
    }
}
