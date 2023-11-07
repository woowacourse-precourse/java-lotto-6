package lotto.domain;

import lotto.utils.LottoPlace;
import lotto.utils.LottoResult;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Lottos {
    private static final int PRICE = 1000;

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos createLottos(Budget budget) {
        List<Lotto> initialLottos = new ArrayList<>();

        int sumLottoPrices = 0;
        while (budget.canBuyALotto(sumLottoPrices)) {
            initialLottos.add(Lotto.createLotto());

            sumLottoPrices += PRICE;
        }

        return new Lottos(initialLottos);
    }

    public String getLottosNumbers() {
        StringJoiner sj = new StringJoiner("\n");

        for (Lotto lotto : lottos) {
            sj.add(lotto.getLottoNumbers());
        }

        return sj.toString();
    }

    public int getLottosSize() {
        return lottos.size();
    }

    public WinningScores calWinningScores(WinningManager winningManager) {
        WinningScores winningScores = new WinningScores();

        for (Lotto lotto : lottos) {
            LottoPlace lottoPlace = lotto.calLottoResult(winningManager);
            winningScores.increaseScore(lottoPlace);
        }

        return winningScores;
    }
}
