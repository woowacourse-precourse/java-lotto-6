package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class AutoLottoNumberGenerator implements NumberGenerateStrategy {

    @Override
    public List<Integer> createNumber() {
        return Randoms.pickUniqueNumbersInRange(Lotto.START_NUMBER, Lotto.END_NUMBER, Lotto.SIZE);
    }
}
