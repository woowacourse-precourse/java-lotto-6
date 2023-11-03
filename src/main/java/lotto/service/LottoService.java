package lotto.service;

import lotto.domain.*;

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

    public LottoResult calculateResult(LottoBundle lottoBundle, AnswerLotto answerLotto) {
        Map<Ranking, Integer> result = new EnumMap<>(Ranking.class);
        for (Lotto lotto : lottoBundle.bundle()) {
            int count = countMatchNumber(lotto, answerLotto);
            boolean bonusContain = checkBonus(lotto, answerLotto);
            Ranking ranking = Ranking.findRanking(count, bonusContain);
            result.put(ranking, result.getOrDefault(ranking, 0) + 1);
        }
        return new LottoResult(result);
    }

    private int countMatchNumber(Lotto lotto, AnswerLotto answerLotto) {
        return answerLotto.getMatchCount(lotto.getNumbers());
    }

    private boolean checkBonus(Lotto lotto, AnswerLotto answerLotto) {
        return lotto.contains(answerLotto.getBonusNumber());
    }
}
