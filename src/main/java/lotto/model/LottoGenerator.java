package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class LottoGenerator {
    public LottoGenerator(int lottoCount) {
            Lotto ticket = new Lotto(sortAscending(pickSixLottoNumber()));
    }
}
