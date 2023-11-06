package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.Comparator;

public class LottoGenerator {
    public static Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> temp = new ArrayList<>(numbers);
        temp.sort(Comparator.naturalOrder());
        Lotto lotto = new Lotto(temp);
        return lotto;
    }
}
