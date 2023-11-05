package lotto.domain;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.domain.LottoStandard.*;

public class AutoLottoGenerator implements LottoGenerator{

    @Override
    public List<Integer> autoLottoGenerator() {
        return pickUniqueNumbersInRange(MIN.getNumber(), MAX.getNumber(), SIZE.getNumber());
    }
}
