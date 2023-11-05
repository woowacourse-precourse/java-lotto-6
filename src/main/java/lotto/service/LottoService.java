package lotto.service;

import lotto.domain.*;
import lotto.dto.LottoBundle;
import lotto.dto.LottoResult;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoService {

    public LottoBundle buyLottoBundle(LottoMoney money) {
        int amount = money.getLottoAmount();
        List<Lotto> bundle = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Lotto lotto = LottoMachine.buyLotto();
            bundle.add(lotto);
        }
        return new LottoBundle(bundle, amount);
    }

    public LottoResult calculateResult(LottoBundle lottoBundle, WinningLotto winningLotto) {
        Map<Ranking, Integer> result = new EnumMap<>(Ranking.class);
        for (Lotto lotto : lottoBundle.bundle()) {
            Ranking ranking = findRanking(lotto, winningLotto);
            result.put(ranking, result.getOrDefault(ranking, 0) + 1);
        }
        return new LottoResult(result, Yield.from(result, lottoBundle.amount()));
    }

    private Ranking findRanking(Lotto lotto, WinningLotto winningLotto) {
        int count = countMatchNumber(lotto, winningLotto);
        boolean bonusContain = checkBonus(lotto, winningLotto);
        return Ranking.findRanking(count, bonusContain);
    }

    private int countMatchNumber(Lotto lotto, WinningLotto winningLotto) {
        return winningLotto.getMatchCount(lotto.numbers());
    }

    private boolean checkBonus(Lotto lotto, WinningLotto winningLotto) {
        return lotto.contains(winningLotto.getBonusNumber());
    }
}
