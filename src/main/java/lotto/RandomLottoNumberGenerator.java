package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomLottoNumberGenerator implements LottoNumberGenerator {

    private static final int lottoNumbersSize = 6;
    private static final int lottoNumberMin = 1;
    private static final int lottoNumberMax = 45;

    @Override
    public List<Integer> create() {
        return Randoms.pickUniqueNumbersInRange(lottoNumberMin, lottoNumberMax, lottoNumbersSize);
    }
}
