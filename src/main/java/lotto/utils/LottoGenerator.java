package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoGenerator {
    private static final int LOW_BOUND = 1;
    private static final int HIGH_BOUND = 45;
    private static final int AMOUNT = 6;

    public static List<Integer> generateLottoNumbers() {
        List<Integer> numbers;

        while (true) {
            numbers = Randoms.pickUniqueNumbersInRange(LOW_BOUND, HIGH_BOUND, AMOUNT);
            Set<Integer> numbersCheck = new HashSet<>(numbers);
            if (numbersCheck.size() == 6) {
                return numbers;
            }
        }
    }
}
