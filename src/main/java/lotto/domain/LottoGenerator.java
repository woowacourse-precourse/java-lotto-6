package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.strategy.LottoGenerateStrategy;

public class LottoGenerator {
    private LottoGenerateStrategy lottoGenerateStrategy;

    public Lotto generateLotto() {
        return this.lottoGenerateStrategy.generate();
    }

    public Lottos generateLottosByBudget(Budget budget) {
        int countOfLottoLine = budget.getCountOfLottoLines();
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < countOfLottoLine; i++) {
            lottos.add(generateLotto());
        }
        return Lottos.from(lottos);
    }

    public void setLottoGenerateStrategy(LottoGenerateStrategy lottoGenerateStrategy) {
        this.lottoGenerateStrategy = lottoGenerateStrategy;
    }
}
