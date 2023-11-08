package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MakeNumber {

    private static final int st_num = 1;
    private static final int ed_num = 45;
    private static final int cnt = 6;

    public List<Integer> MakeRandom() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(st_num, ed_num, cnt));
        Collections.sort(numbers);
        return numbers;
    }

}
