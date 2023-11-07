package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.logic.Logic;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private List<Lotto> lotteries = new ArrayList<>();

    public void generateLotto(int payment) {
        int count = payment / Logic.LOTTERY_COST;
        for (int i = 0; i < count; i++) {
            lotteries.add(new Lotto(Randoms.pickUniqueNumbersInRange(
                    Logic.START_RANGE
                    , Logic.END_RANGE
                    , Logic.NUMBER_COUNT))
            );
        }
    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }
}
