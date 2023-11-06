package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class AutoLottoGenerator implements LottoNumberGenerateStrategy {

    @Override
    public List<Integer> createLotto() {
        return Randoms.pickUniqueNumbersInRange(Lotto.START_NUMBER, Lotto.END_NUMBER, Lotto.SIZE);
    }
}
