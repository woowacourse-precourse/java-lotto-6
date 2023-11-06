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

    public LottoManager(Lottos lottos, LottoAnswer lottoAnswer) {
        this.lottos = lottos;
        this.lottoAnswer = lottoAnswer;
    }

    public List<Rank> calculateResults() {
        List<Rank> results = new ArrayList<>();

        for (Lotto lotto : lottos) {
            results.add(lottoAnswer.getRankOf(lotto));
        }

        return results;
    }
}
