package lotto;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberPicker {
    private final int START_RANGE = 1;
    private final int END_RANGE = 45;
    private final int COUNT = 6;

    private List<Integer> getRandomNum() {
        return Randoms.pickUniqueNumbersInRange(START_RANGE, END_RANGE, COUNT);
    }
}
