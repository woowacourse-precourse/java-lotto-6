package lotto.service;

import java.util.List;
import lotto.common.MultiplePureNumbers;
import lotto.common.PureNumber;
import lotto.core.BonusNumber;
import lotto.core.DrawResult;
import lotto.core.LotteryPortfolio;
import lotto.core.LotteryTicket;
import lotto.core.PortfolioReport;
import lotto.core.PurchaseAmount;
import lotto.core.RandomLotteryNumberProvider;

public class LottoService {

    private LotteryTicket winningLotteryTicket;
    private BonusNumber bonusNumber;
    private LotteryPortfolio portfolio;

    public LottoService() {
        portfolio = new LotteryPortfolio();
    }

    public LottoService(List<Integer> winningNumbers, BonusNumber bonusNumber) {
        this.winningLotteryTicket = new LotteryTicket(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public LotteryPortfolio issueRequiredAmountOfLotteryTickets(PureNumber number) throws IllegalArgumentException {
        PurchaseAmount amount = PurchaseAmount.amountOf(number);
        for (int i = 0; i < amount.getTicketQuantity(); i++) {
            portfolio.add(new LotteryTicket(RandomLotteryNumberProvider.lotteryNumbers()));
        }
        return portfolio;
    }

    public void setWinningNumbers(MultiplePureNumbers numbers) throws IllegalArgumentException {
        winningLotteryTicket = LotteryTicket.create(numbers);
    }

    public void setBonusNumber(PureNumber number) throws IllegalArgumentException {
        bonusNumber = BonusNumber.create(winningLotteryTicket, number);
    }

    public DrawResult checkResult(LotteryTicket lotteryTicket) {
        return DrawResult.resultOf(lotteryTicket.countHitNumbers(this.winningLotteryTicket),
                containsBonusNumber(lotteryTicket));
    }

    public boolean containsBonusNumber(LotteryTicket lotteryTicket) {
        return lotteryTicket.containsBonusNumber(this.bonusNumber);
    }

    public PortfolioReport analyzePortfolio() {
        return portfolio.analyze(winningLotteryTicket, bonusNumber);
    }
}
