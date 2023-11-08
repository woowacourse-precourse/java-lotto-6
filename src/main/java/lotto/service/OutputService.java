package lotto.service;

import lotto.domain.committee.Committee;
import lotto.domain.lotto.Lottos;
import lotto.domain.money.Money;
import lotto.domain.prize.Prize;
import lotto.view.OutputView;

public class OutputService {
    private final OutputView outputView;

    public OutputService(OutputView outputView) {
        this.outputView = outputView;
    }

    public void purchaseAmount() {
        outputView.purchaseAmount();
    }

    public void lottos(Money money, Lottos lottos) {
        outputView.lottos(money.ticketCount(), lottos.printLottos());
    }

    public void winningNumbers() {
        outputView.winningNumbers();
    }

    public void bonusNumber() {
        outputView.bonusNumber();
    }

    public void handleException(IllegalArgumentException exception) {
        outputView.printExceptionMessage(exception.getMessage());
    }

    public void winningStats(Money money, Committee committee) {
        outputView.winningStats();
        for (Prize prize : Prize.values()) {
            if (prize.isNothing()) {
                continue;
            }
            int resultCount = committee.getResultCount(prize);
            outputView.prizeResult(prize, resultCount);
        }
        float earningsRate = committee.calculateEarningsRate(money);
        outputView.earningsRate(earningsRate);
    }
}
