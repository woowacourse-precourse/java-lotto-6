package lotto.Function;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class GenerateLottoNumbers {
    private static final Integer MIN_RANGE = 1;
    private static final Integer MAX_RANGE = 45;
    private static final Integer PICKUP_NUMBER = 6;

    public List<Integer> generateLotto_RandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, PICKUP_NUMBER);
    }
}
