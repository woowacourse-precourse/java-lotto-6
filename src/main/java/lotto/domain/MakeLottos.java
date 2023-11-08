package lotto.domain;

import java.util.List;
import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;

public class MakeLottos {
    static final int START_INCLUSIVE = 1;
    static final int END_INCLUSIVE = 45;
    static final int LOTTO_CNT = 6;

    public static List<List<Integer>> makeLotto(int purchaseNum) {
        List<List<Integer>> allLotto = new ArrayList<>();
        for (var i = 0; i < purchaseNum; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, LOTTO_CNT);
            allLotto.add(numbers);
        }
        return allLotto;
    }

}
