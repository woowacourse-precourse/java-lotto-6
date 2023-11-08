package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomPicker {
    private final static int MIN_PICK_NUMBER = 1;
    private final static int MAX_PICK_NUMBER = 45;
    private final static int COUNT_PICK_NUMBER = 6;

    public static List<Integer> randomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_PICK_NUMBER, MAX_PICK_NUMBER, COUNT_PICK_NUMBER);
    }
}
