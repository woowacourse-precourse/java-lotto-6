package lotto.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Rank;
import lotto.domain.LottoMachine;
import lotto.domain.LottoScanner;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.ProfitRateCalculator;
import lotto.domain.WinningLotto;

public class LottoService {
    private final LottoMachine lottoMachine = new LottoMachine();
    private final LottoScanner lottoScanner = new LottoScanner();
    private final ProfitRateCalculator profitRateCalculator = new ProfitRateCalculator();

    public LottoService() {
    }

    public ConsoleOutDTO respondToRequest(Money money, WinningLotto winningLotto) {
        Lottos lottos = lottoMachine.issueLottos(money);
        List<Rank> lottoResult = lottoScanner.sendAnalyzedResult(lottos, winningLotto);
        double profitRate = profitRateCalculator.calculateProfitRate(lottoResult, money);

        return new ConsoleOutDTO(lottos.numberOfLotto(), lottos, ranksToFifthToFirst(lottoResult), profitRate);
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
