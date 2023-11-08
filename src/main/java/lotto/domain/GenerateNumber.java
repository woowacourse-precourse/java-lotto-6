package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class GenerateNumber {
    private static final Integer MIN_RANGE = 1;
    private static final Integer MAX_RANGE = 45;
    private static final Integer PICK_NUMBER = 6;
    public List<Integer> randomLottoCreate() {
        return Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, PICK_NUMBER);
    }
}
