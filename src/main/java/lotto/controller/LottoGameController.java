package lotto.controller;

import static lotto.view.constants.OutputMessage.RESULT_MESSAGE;
import static lotto.view.constants.OutputMessage.WINNING_BONUS_MESSAGE;
import static lotto.view.constants.OutputMessage.WINNING_MESSAGE;
import static lotto.view.constants.OutputMessage.WINNING_STATISTICS_MESSAGE;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.config.GamePrizeConfig;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.PurchasedLotto;
import lotto.view.OutputView;

public class LottoGameController {
    private final PurchasedLottoService purchasedLottoService;
    private final WinningLottoService winningLottoService;
    private final BonusNumberService bonusNumberService;

    public LottoGameController(PurchasedLottoService purchasedLottoService, WinningLottoService winningLottoService, BonusNumberService bonusNumberService) {
        this.purchasedLottoService = purchasedLottoService;
        this.winningLottoService = winningLottoService;
        this.bonusNumberService = bonusNumberService;
    }

    public void run() {
        int purchaseAmount = purchasedLottoService.inputPurchaseAmount();
        PurchasedLotto purchasedLotto = purchasedLottoService.createPurchasedLotto(purchaseAmount);
        Lotto winningLotto = winningLottoService.craeteWinningLotto();
        BonusNumber bonusNumber = bonusNumberService.craeteBonusNumber(winningLotto);

        LottoResult lottoResult = createLottoResult(purchasedLotto, winningLotto, bonusNumber);
        printWinningStatistics(lottoResult, purchaseAmount);
    }

    private LottoResult createLottoResult(PurchasedLotto purchasedLotto, Lotto winningLotto, BonusNumber bonusNumber) {
        List<Integer> winningResult = purchasedLotto.getWinningResult(winningLotto, bonusNumber);
        return new LottoResult(winningResult);
    }

    private void printWinningStatistics(LottoResult lottoResult, int purchaseAmount) {
        OutputView.printNewLine();
        OutputView.printMessage(WINNING_STATISTICS_MESSAGE.getMessage());

        List<GamePrizeConfig> prizes = Arrays.asList(GamePrizeConfig.values());
        Collections.reverse(prizes);
        int winningIndex = prizes.size() - 1;
        for (GamePrizeConfig prize : prizes) {
            String winningMessage = WINNING_MESSAGE.getMessage();;
            if (prize.getCheckBonus()) {
                winningMessage = WINNING_BONUS_MESSAGE.getMessage();
            }
            OutputView.printMessage(String.format(
                    winningMessage,
                    prize.getCorrectCount(),
                    prize.getPrizeText(),
                    lottoResult.getCount(winningIndex)
            ));
            winningIndex--;
        }

        double incomeRate = calculateIncomeRate(lottoResult, purchaseAmount);
        OutputView.printMessage(String.format(RESULT_MESSAGE.getMessage(), incomeRate));
    }

    private double calculateIncomeRate(LottoResult lottoResult, int purchaseAmount) {
        return (double) lottoResult.getIncome() / purchaseAmount * 100;
    }
}
