package lotto;

import java.util.List;

public class LottoService {

    private LotteryTicket winningLotteryTicket;
    private BonusNumber bonusNumber;

    public LottoService() { }

    public LottoService(LotteryTicket winningLotteryTicket, BonusNumber bonusNumber) {
        this.winningLotteryTicket = winningLotteryTicket;
        this.bonusNumber = bonusNumber;
    }

    public LottoService(List<Integer> winningNumbers, BonusNumber bonusNumber) {
        this.winningLotteryTicket = new LotteryTicket(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public DrawResult checkResult(LotteryTicket lotteryTicket) {
        return DrawResult.resultOf(lotteryTicket.countHitNumbers(this.winningLotteryTicket),
                containsBonusNumber(lotteryTicket));
    }

    public boolean containsBonusNumber(LotteryTicket lotteryTicket) {
        return lotteryTicket.containsBonusNumber(this.bonusNumber);
    }

    public PortfolioReport analyzePortfolio(LotteryPortfolio portfolio) {
        return portfolio.analyze(winningLotteryTicket, bonusNumber);
    }
}
