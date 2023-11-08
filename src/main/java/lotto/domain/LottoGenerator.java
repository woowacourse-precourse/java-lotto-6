package lotto.domain;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class LottoGenerator {
    private List<Lotto> LottoTrials = new ArrayList<>();

    public LottoGenerator(int trials) {
        generateLottoTrials(trials);
    }

    private void generateLottoTrials(int trials) {
        for (int i = 0; i < trials; i++) {
            Lotto trial = new Lotto(pickUniqueNumbersInRange(1, 45, 6));
            trial.printLotto();
            LottoTrials.add(trial);
        }
    }

    public List<Lotto> getLottoTrials() {
        return this.LottoTrials;
    }
}
