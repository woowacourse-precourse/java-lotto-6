package lotto.controller;

import lotto.controller.inputController.LottoPurchaseController;
import lotto.controller.inputController.LottoWinningNumberController;
import lotto.controller.outputController.LottoPrintController;
import lotto.controller.outputController.LottoReturnsController;
import lotto.controller.outputController.LottoWinningStatisticsController;
import lotto.model.lottoGenerator.Lotto;
import lotto.model.lottoGenerator.LottoTicketCreator;
import lotto.model.lottoResultChecker.LottoMatchingData;
import lotto.model.lottoResultChecker.LottoRank;
import lotto.model.lottoResultChecker.LottoRankChecker;
import lotto.model.lottoResultChecker.LottoReturnsCalculator;
import lotto.view.inputView.LottoBonusWinningNumberInput;
import lotto.view.outputView.LottoReturnsOutput;


import java.util.List;
import java.util.Map;

public class LottoController {

    private final LottoPurchaseController purchaseController = new LottoPurchaseController();
    private final LottoPrintController lottoPrintController = new LottoPrintController();
    private final LottoTicketCreator ticketCreator = new LottoTicketCreator();
    private final LottoWinningNumberController winningNumberController = new LottoWinningNumberController();
    private final LottoBonusWinningNumberInput bonusNumberInput = new LottoBonusWinningNumberInput();
    private final LottoRankChecker rankChecker = new LottoRankChecker();
    private final LottoWinningStatisticsController statisticsController = new LottoWinningStatisticsController();
    private final LottoReturnsCalculator returnsCalculator = new LottoReturnsCalculator(1000);
    private final LottoReturnsOutput returnsOutput = new LottoReturnsOutput();
    private final LottoReturnsController returnsController = new LottoReturnsController(returnsCalculator, returnsOutput);


    public void start() {
        int purchaseAmount = purchaseController.getPurchaseAmount();
        List<Lotto> lotto = ticketCreator.createLottoTickets(purchaseAmount);
        lottoPrintController.handleLottoDisplay(lotto);
        List<Integer> winningNumbers = winningNumberController.getWinningNumbers();
        int bonusNumber = bonusNumberInput.requestBonusNumber();
        LottoMatchingData matchingData = new LottoMatchingData();
        matchingData.matchLottoToWinningNumbers(lotto, winningNumbers, bonusNumber);
        Map<LottoRank, Integer> rankResult = rankChecker.determineRank(matchingData);
        statisticsController.displayStatistics(rankResult);
        returnsController.displayReturnRate(rankResult, purchaseAmount);
    }
}