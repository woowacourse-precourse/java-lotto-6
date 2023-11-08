package lotto.controller;

import lotto.model.Lotto;
import lotto.model.WinningLotto;
import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoGameController {
    private InputView inputView;
    private OutputView outputView;

    public LottoGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        PurchaseAmount purchaseAmount = inputPurchaseAmount();

        LottoManager lottoManager = initLottoManager(purchaseAmount);

        generateLotto(lottoManager);
        printLotto(lottoManager);

        WinningLotto winningLotto = inputWinningLotto();

        LottoResultManager resultManager = initRankManager(winningLotto);

        generateResult(resultManager, lottoManager);
        printResult(resultManager, purchaseAmount);
    }

    private PurchaseAmount inputPurchaseAmount() {
        try {
            outputView.printInputPurchaseMoney();
            return new PurchaseAmount(inputView.readPurchaseMoney());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return inputPurchaseAmount();
        }
    }

    private WinningLotto inputWinningLotto() {
        try {
            List<Integer> winningNumbers = inputWinningNumbers();
            outputView.printBlankLine();
            int bonus = inputWinningBonus();
            outputView.printBlankLine();
            return new WinningLotto(winningNumbers, bonus);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return inputWinningLotto();
        }
    }

    private List<Integer> inputWinningNumbers() {
        try {
            outputView.printInputWinningNumbers();
            return inputView.readWinningNumbers();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return inputWinningNumbers();
        }
    }

    private int inputWinningBonus() {
        try {
            outputView.printInputBonusNumber();
            return inputView.readBonusNumber();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return inputWinningBonus();
        }
    }

    private LottoManager initLottoManager(PurchaseAmount purchaseAmount) {
        LottoGenerator generator = new LottoGenerator();
        int ticketNumber = purchaseAmount.getTicketNumber();
        return new LottoManager(generator, ticketNumber);
    }

    private LottoResultManager initRankManager(WinningLotto winningLotto) {
        LottoRankResult rankResult = new LottoRankResult();
        LottoPrizeResult prizeResult = new LottoPrizeResult();
        return new LottoResultManager(winningLotto, rankResult, prizeResult);
    }

    private void generateLotto(LottoManager lottoManager) {
        lottoManager.generateLottos();
    }

    private void generateResult(LottoResultManager rankManager, LottoManager lottoManager) {
        List<Lotto> lottos = lottoManager.getLottos();
        rankManager.generateResult(lottos);
    }

    private void printLotto(LottoManager lottoManager) {
        int ticketNumber = lottoManager.getTicketNumber();
        outputView.printBlankLine();
        outputView.printTicketNumber(ticketNumber);

        List<Lotto> lottos = lottoManager.getLottos();
        outputView.printLottos(lottos);
    }

    private void printResult(LottoResultManager rankManager, PurchaseAmount purchaseAmount) {
        LottoRankResult rankResult = rankManager.getRankResult();
        outputView.printLottoResult(rankResult);

        int purchaseMoney = purchaseAmount.getPurchaseMoney();
        double rateOfReturn = rankManager.getRateOfReturn(purchaseMoney);
        outputView.printRateOfReturn(rateOfReturn);
    }
}
