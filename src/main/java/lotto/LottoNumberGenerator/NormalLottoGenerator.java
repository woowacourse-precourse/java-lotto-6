package lotto.LottoNumberGenerator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class NormalLottoGenerator implements LottoGenerator {
    private final int LOTTO_START_NUMBER = 1;
    private final int LOTTO_END_NUMBER = 45;
    private final int LOTTO_AMOUNT = 6;

    @Override
    public List<Integer> pickLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_AMOUNT);
    }
}
