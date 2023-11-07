package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {
    private static final int START = 1;
    private static final int END = 45;
    private static final int SIZE = 6;
    public static List<Integer> createNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(START, END, SIZE);
        Collections.sort(randomNumbers);
        return randomNumbers;
    }
}
