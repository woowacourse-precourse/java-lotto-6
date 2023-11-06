package lotto.service;

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

    public consoleOutDTO respondToRequest(Money money, WinningLotto winningLotto) {
        Lottos lottos = lottoMachine.issueLottos(money);
        List<Rank> lottoResult = lottoScanner.sendAnalyzedResult(lottos, winningLotto);
        long profitRate = profitRateCalculator.calculateProfitRate(lottoResult, money);

        return new consoleOutDTO(lottos.numberOfLotto(), lottos, lottoResult, profitRate);
    }
}
