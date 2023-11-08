package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class LottoNumbers {

    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int COUNT = 6;

    public LottoNumbers() {
    }

    public static List<Integer> setLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN, MAX, COUNT);
        Collections.sort(numbers);
        return numbers;
    }
}
