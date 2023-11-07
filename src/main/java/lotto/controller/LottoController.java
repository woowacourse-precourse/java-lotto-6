package lotto.controller;


import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    public void run() {
        UserAmount userAmount = InputView.getUserAmount();
        int issueAbleCount = userAmount.calculateIssueAbleCount();
        OutputView.printIssueAbleCount(issueAbleCount);

        LottoPublisher lottoPublisher = new LottoPublisher(issueAbleCount);
        List<List<Integer>> lottos = lottoPublisher.getLottos();
        OutputView.printLottosByAmount(lottos);

        WinningBundle winningBundle = InputView.getWinningBundle();
        BonusNumber bonusNumber = InputView.getBonusNumber();

        LottoResult lottoResult = new LottoResult(lottos, winningBundle.getWinningBundle(), bonusNumber.toInt());
        List<Long> correctWinningsCount = lottoResult.getCorrectWinningsCount();
        List<Boolean> correctBonuses = lottoResult.getCorrectBonuses();

        WinningTier winningTier = new WinningTier();
        winningTier.estimate(correctWinningsCount, correctBonuses);
        OutputView.printWinningStaticsInput();
        OutputView.printWinningStatics(winningTier.getWinningTier());

        WinnerRevenue winnerRevenue = new WinnerRevenue(correctWinningsCount, correctBonuses);
        RevenueDto revenueDto = winnerRevenue.generateRevenueDto(userAmount.getUserAmount());
        OutputView.printWinningRevenue(revenueDto);

    }

    public void publishLottos() {

    }

}

