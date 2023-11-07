package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private List<Lotto> lotteries = new ArrayList<>();
    private final int startRange;
    private final int endRange;
    private final int numberCount;
    private final int cost;

    public LottoController(int startRange, int endRange, int numberCount, int cost) {
        this.startRange = startRange;
        this.endRange = endRange;
        this.numberCount = numberCount;
        this.cost = cost;
    }

    public void generateLotto(int payment) {
        int count = payment / cost;
        for (int i = 0; i < count; i++) {
            lotteries.add(new Lotto(Randoms.pickUniqueNumbersInRange(startRange, endRange, numberCount)));
        }
    }

}
