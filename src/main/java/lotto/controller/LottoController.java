package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoManager;
import lotto.domain.LottoShop;
import lotto.domain.LottosResult;
import lotto.domain.PurchaseAmount;
import lotto.domain.Rank;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        PurchaseAmount purchaseAmount = getPurchaseAmount();
        List<Lotto> userLottos = getUserLottos(purchaseAmount);
        List<Integer> winningNumbers = getWinningLottoNumbers();

        outputView.printLottos(userLottos, LottoShop.countLottoTicket(purchaseAmount));

        Map<Rank, Integer> lottosRanks = getLottosRanks(winningNumbers, userLottos);

        printResult(lottosRanks, purchaseAmount);
    }

    private List<Integer> getWinningLottoNumbers() {
        try {
            List<Integer> winningNumbers = inputView.inputWinningNumbers();
            Lotto winningLotto = new Lotto(winningNumbers);
            return winningNumbers;
        } catch (IllegalArgumentException exception) {
            outputView.printError(exception.getMessage());
            return getWinningLottoNumbers();
        }
    }

    private LottoManager generateLottoManager(List<Integer> winningNumbers, int bonusNumber) {
        try {
            LottoManager lottoManager = new LottoManager(winningNumbers, bonusNumber);
            return lottoManager;
        } catch (IllegalArgumentException exception) {
            outputView.printError(exception.getMessage());
            return generateLottoManager(winningNumbers, getBonusNumber());
        }
    }

    private PurchaseAmount getPurchaseAmount() {
        try {
            int amount = inputView.inputPurchaseAmount();
            PurchaseAmount purchaseAmount = new PurchaseAmount(amount);
            LottoShop.validateAmountDivisible(purchaseAmount);
            return purchaseAmount;
        } catch (IllegalArgumentException exception) {
            outputView.printError(exception.getMessage());
            return getPurchaseAmount();
        }
    }

    private int getBonusNumber() {
        try {
            return inputView.inputBonusNumber();
        } catch (IllegalArgumentException exception) {
            outputView.printError(exception.getMessage());
            return getBonusNumber();
        }
    }

    private List<Lotto> getUserLottos(PurchaseAmount purchaseAmount) {
        return LottoShop.createLottosBy(purchaseAmount);
    }

    private void printResult(Map<Rank, Integer> lottosRanks, PurchaseAmount purchaseAmount) {
        outputView.printResultStatistics(LottosResult.countEachRank(lottosRanks));
        outputView.printRateOfReturn(LottoShop.countLottoTicket(purchaseAmount), LottosResult.calculateTotalPrize(lottosRanks));
    }

    private Map<Rank, Integer> getLottosRanks(List<Integer> winningNumbers, List<Lotto> lottos) {
        LottoManager lottoManager = generateLottoManager(winningNumbers, getBonusNumber());
        return lottoManager.calculateLottosRanks(lottos);

    }
}
