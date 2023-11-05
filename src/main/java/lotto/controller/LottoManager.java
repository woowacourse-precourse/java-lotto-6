package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoAnswer;
import lotto.model.Lottos;
import lotto.model.Rank;

public class LottoManager {

    private final Lottos lottos;
    private final LottoAnswer lottoAnswer;

    public LottoManager(LottoAnswer lottoAnswer) {
        this.lottos = new Lottos();
        this.lottoAnswer = lottoAnswer;
    }

    public void purchaseLottos(int amount) {
        for (int i = 0; i < amount; i++) {
            lottos.addLotto();
        }
    }

    public List<Rank> calculateResults() {
        List<Rank> results = new ArrayList<>();

        for (Lotto lotto : lottos) {
            results.add(lottoAnswer.getRankOf(lotto));
        }

        return results;
    }
}
