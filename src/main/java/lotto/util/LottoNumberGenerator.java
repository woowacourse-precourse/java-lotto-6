package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoNumberGenerator {

    private LottoNumberGenerator() {}

    public static LottoNumberGenerator getInstance() {
        return new LottoNumberGenerator();
    }

    public List<Integer> makeLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }
}
