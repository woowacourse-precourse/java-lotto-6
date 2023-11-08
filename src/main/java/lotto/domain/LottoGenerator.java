package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Constant.LottoNumber;

import java.util.*;
import java.util.Comparator;

public class LottoGenerator {
    public static Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LottoNumber.MIN.getValue(), LottoNumber.MAX.getValue(), LottoNumber.COUNT.getValue());
        List<Integer> temp = new ArrayList<>(numbers);
        temp.sort(Comparator.naturalOrder());
        Lotto lotto = new Lotto(temp);
        return lotto;
    }
}
