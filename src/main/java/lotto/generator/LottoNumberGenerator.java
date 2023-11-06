package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoNumberGenerator {
    private static final Integer LOTTO_START_NUMBER = 1;
    private static final Integer LOTTO_END_NUMBER = 45;
    private static final Integer LOTTO_COUNT = 6;

    public List<Integer> generateLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_COUNT);
    }


}
