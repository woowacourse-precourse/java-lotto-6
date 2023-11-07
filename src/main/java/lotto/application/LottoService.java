package lotto.application;

import lotto.domain.*;

import java.util.HashMap;
import java.util.Map;

public class LottoService {

    private final LottoGenerator lottoGenerator;

    public LottoService(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public Lottos purchaseLottos(Money money) {
        return lottoGenerator.generateLotto(money);
    }

    public LottoResult calculateLottoResult(Lottos lottos, WinningInfo winningInfo) {
        Map<Rank, Integer> result = new HashMap<>();

        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }

        lottos.getLottos().stream().map(winningInfo::match).forEach(
                rank -> result.put(rank, result.get(rank) + 1)
        );

        return LottoResult.of(result);
    }
}
