package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.view.OutputView;

public class LottoComparator {
    private Lottos lottos;
    private WinningLotto winningLotto;
    private LottosResult lottosResult;

    public LottoComparator(Lottos lottos, WinningLotto winningLotto) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
        this.lottosResult = new LottosResult();
    }

    public void compare() {
        getLottosResult();
        lottosResult.calculateRateOfReturn(lottos.size() * 1000);
        OutputView.print(lottosResult.toString());
    }


    public List<LottoResult> compareLottoAndWinningLotto() {
        List<LottoResult> results = new ArrayList<>();
        for (int i = 0; i < lottos.size(); i++) {
            results.add(winningLotto.compareToLotto(lottos.get(i)));
        }
        return results;
    }

    public void getLottosResult() {
        List<LottoResult> lottoResults = compareLottoAndWinningLotto();
        for (LottoResult lottoResult : lottoResults) {
            if (lottoResult.getWinners() == null) {
                continue;
            }
            lottosResult.put(lottoResult.getWinners(), lottosResult.get(lottoResult.getWinners()) + 1);
        }
    }

}
