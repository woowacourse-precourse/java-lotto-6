package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.UserAmount;
import lotto.domain.WinningBundle;
import lotto.dto.LottoPurchaseResultDto;
import lotto.dto.LottoResultDto;
import lotto.dto.RevenueDto;
import lotto.dto.WinningBundleDto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private static int issueAbleCount;
    private static WinningBundle winningBundle;
    private static BonusNumber bonusNumber;
    private static LottoResultDto lottoResultDto;

    private final LottoService lottoService = new LottoService();

    public void run() {
        UserAmount userAmount = InputView.getUserAmount();
        calculateIssueAbleCount(userAmount);
        LottoPurchaseResultDto lottoPurchaseResultDto = purchaseLottosByAmount(userAmount);
        decideWinningBundleAndBonusNumber();
        evaluateWinnings(lottoPurchaseResultDto);
        calculateRevenue(userAmount);
    }

    private static void calculateIssueAbleCount(UserAmount userAmount) {
        issueAbleCount = userAmount.calculateIssueAbleCount();
        OutputView.printIssueAbleCount(issueAbleCount);
    }

    private static void decideWinningBundleAndBonusNumber() {
        winningBundle = InputView.getWinningBundle();
        WinningBundleDto winningBundleDto = winningBundle.getWinningBundleDto();
        OutputView.printEnter();
        bonusNumber = InputView.getBonusNumber(winningBundleDto);
    }

    private void evaluateWinnings(LottoPurchaseResultDto lottoPurchaseResult) {
        lottoResultDto = lottoService.evaluateWinnings(lottoPurchaseResult, winningBundle, bonusNumber);
        OutputView.printWinningStaticsInput();
        OutputView.printWinningStatics(lottoResultDto.getWinningStatistics());
    }

    private LottoPurchaseResultDto purchaseLottosByAmount(UserAmount userAmount) {
        LottoPurchaseResultDto lottoPurchaseResult = lottoService.purchaseLottos(userAmount);
        OutputView.printLottosByAmount(lottoPurchaseResult);
        return lottoPurchaseResult;
    }

    private void calculateRevenue(UserAmount userAmount) {
        RevenueDto revenueDto = lottoService.calculateRevenue(userAmount, lottoResultDto);
        OutputView.printWinningRevenue(revenueDto);
    }

}

