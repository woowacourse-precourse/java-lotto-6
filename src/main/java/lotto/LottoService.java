package lotto;

import java.util.List;

public class LottoService {

    private Lotto winningLotto;
    private BonusNumber bonusNumber;

    public LottoService() { }

    public LottoService(Lotto winningLotto, BonusNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public LottoService(List<Integer> winningNumbers, BonusNumber bonusNumber) {
        this.winningLotto = new Lotto(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public DrawResult checkResult(Lotto lotto) {
        return DrawResult.resultOf(lotto.countHitNumbers(this.winningLotto),
                containsBonusNumber(lotto));
    }

    public boolean containsBonusNumber(Lotto lotto) {
        return lotto.containsBonusNumber(this.bonusNumber);
    }

    public PortfolioReport analyzePortfolio(LotteryPortfolio portfolio) {
        return portfolio.analyze(winningLotto, bonusNumber);
    }
}
