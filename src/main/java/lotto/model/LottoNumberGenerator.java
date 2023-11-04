package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumberGenerator implements NumberGenerator {
    private static final int LOTTO_NUMBER_START_RANGE = 1;
    private static final int LOTTO_NUMBER_END_RANGE = 45;

    @Override
    public List<Integer> generate(){
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_START_RANGE, LOTTO_NUMBER_END_RANGE, 6);
    }
}
