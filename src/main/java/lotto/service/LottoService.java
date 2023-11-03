package lotto.service;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static lotto.domain.LottoMoney.MONEY_UNIT;

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
            int count = countMatchNumber(lotto, winningLotto);
            boolean bonusContain = checkBonus(lotto, winningLotto);
            Ranking ranking = Ranking.findRanking(count, bonusContain);
            result.put(ranking, result.getOrDefault(ranking, 0) + 1);
        }
        return new LottoResult(result, calculateYield(result, lottoBundle.amount()));
    }

    private int countMatchNumber(Lotto lotto, WinningLotto winningLotto) {
        return winningLotto.getMatchCount(lotto.numbers());
    }

    private boolean checkBonus(Lotto lotto, WinningLotto winningLotto) {
        return lotto.contains(winningLotto.getBonusNumber());
    }

    private double calculateYield(Map<Ranking, Integer> result, int amount) {
        double sumPrize = 0;
        for (Ranking ranking : result.keySet()) {
            double count = result.get(ranking);
            sumPrize += ranking.multiplePrize(count);
        }
        return sumPrize / (amount * MONEY_UNIT) * 100;
    }
}
