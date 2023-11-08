package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.support.LottoComparator;
import lotto.support.Rate;
import lotto.util.ResultOutputManager;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    private final List<Rate> rate = new ArrayList<>();

    public void execute(List<Lotto> lottos, WinningLotto winningLotto) {

        LottoComparator lottoComparator = new LottoComparator(winningLotto.getWinning(), winningLotto.getBonus());

        compareLottos(lottos, lottoComparator);
        ResultOutputManager resultOutputManager = new ResultOutputManager(rate);
        resultOutputManager.print();
    }

    private void compareLottos(List<Lotto> lottos, LottoComparator lottoComparator) {
        for (int i = 0; i < lottos.size(); i++) {
            rate.add(lottoComparator.compareLotto(lottos.get(i)));
        }
    }

    public int getRateSize() {
        return rate.size();
    }

}
