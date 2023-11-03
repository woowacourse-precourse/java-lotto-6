package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class NumberPicker {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    public List<Integer> createNumbers() {
        return Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, LOTTO_SIZE);
    }
}
