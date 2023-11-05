package lotto.domain;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static java.util.Collections.*;
import static lotto.domain.LottoStandard.*;

public class AutoLottoGenerator implements LottoGenerator{

    @Override
    public List<Integer> generateLotto() {
        List<Integer> lotto = pickUniqueNumbersInRange(MIN.getNumber(), MAX.getNumber(), SIZE.getNumber());
        sort(lotto);

        return lotto;
    }
}
