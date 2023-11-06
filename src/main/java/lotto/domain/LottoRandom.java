package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LottoRandom {
    private static int MIN = 1;
    private static int MAX = 45;
    private static int SIZE = 6;

    public List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN,MAX,SIZE);
    }

}
