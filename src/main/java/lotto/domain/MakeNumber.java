package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import lotto.Lotto;

public class MakeNumber {

    private static final int st_num = 1;
    private static final int ed_num = 45;
    private static final int cnt = 6;

    public static void MakeRandom(List<Lotto> lottos, Long price) {
        for (int i = 0; i < price / 1000; i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(st_num, ed_num, cnt));
            Collections.sort(numbers);
            lottos.add(new Lotto(numbers));
        }

        Output.PrintLotto(lottos);
    }

}
