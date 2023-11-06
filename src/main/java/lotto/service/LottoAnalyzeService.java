package lotto.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Rank;
import lotto.domain.LottoScanner;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.ProfitRateCalculator;
import lotto.domain.WinningLotto;

public class LottoAnalyzeService {
    private LottoScanner lottoScanner = new LottoScanner();
    private ProfitRateCalculator profitRateCalculator = new ProfitRateCalculator();

    public LottoAnalyzeService() {
    }

    public ResultDTO sendAnalyzedData(Lottos lottos, WinningLotto winningLotto, Money money) {
        List<Rank> ranks = lottoScanner.sendAnalyzedResult(lottos, winningLotto);
        double profitRate = profitRateCalculator.calculateProfitRate(ranks, money);

        return new ResultDTO(ranksToFifthToFirst(ranks), profitRate);
    }

    private List<Integer> ranksToFifthToFirst(List<Rank> lottoResult) {
        List<Integer> FifthToFirst = new ArrayList<>();
        for(Rank rank : Rank.values()) {
            FifthToFirst.add(Collections.frequency(lottoResult, rank));
        }
        Collections.reverse(FifthToFirst);
        return FifthToFirst;
    }
}
