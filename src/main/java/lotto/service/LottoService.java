package lotto.service;

import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;

public class LottoService {

    public static LottoResult getLottoResult(Lottos lottos, WinningLotto winningLotto) {
        LottoResult results = new LottoResult();

        lottos.getLottos().stream()
            .map(winningLotto::match)
            .forEach(results::addRank);

        return results;
    }
}
