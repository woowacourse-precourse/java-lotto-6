package lotto.controller;

import java.util.Map;
import lotto.domain.*;
import lotto.service.LottoService;
import lotto.utils.InputProcessor;
import lotto.utils.Validation;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private Lotto winningNumbers;
    private User user;
    private LottoData lottoData;
    private final LottoService lottoService;
    private final OutputView outputView;
    private final InputProcessor inputProcessor;

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.outputView = outputView;
        this.inputProcessor = new InputProcessor(inputView);
    }

    public void run() {
        beforeStart();
        setLottoData();
        lottoService.checkWinningsForUserLottos(user, lottoData);
        printStatistics(lottoService.getWinningCounts(), calculateTotalPrize(lottoService.getWinningCounts()));
    }

    private void beforeStart() {
        try {
            outputView.getInputAmount();
            int purchaseAmount = inputProcessor.getUserInputPurchaseAmount();
            user = new User(new Amount(purchaseAmount));
            lottoService.buyLottoAll(user);
            printBuyLotto();
        } catch (IllegalArgumentException e) {
            beforeStart();
        }
    }

    private void printBuyLotto() {
        outputView.printLottoCount(user.getPurchaseAmount().getAmount() / 1_000);
        for (Lotto lotto : user.getLottos()) {
            outputView.printLottoNumbers(lotto.getNumbers());
        }
    }

    private void setLottoData() {
        lottoData = lottoService.setWinningNumbers(setWinningNumbers(), setBonusNumber());
    }

    private Lotto setWinningNumbers() {
        try {
            outputView.getInputWinningNumbers();
            List<Integer> userInputWinningNumbers = inputProcessor.getUserInputWinningNumbers();
            winningNumbers = new Lotto(userInputWinningNumbers);
            return winningNumbers;
        } catch (IllegalArgumentException e) {
            return setWinningNumbers();
        }
    }

    private BonusNumber setBonusNumber() {
        try {
            outputView.getInputBonusNumber();
            int bonusNumber = inputProcessor.getUserInputBonusNumber();
            Validation.validateBonusNumberNotInWinningNumber(bonusNumber, winningNumbers.getNumbers());
            return new BonusNumber(bonusNumber);
        } catch (IllegalArgumentException e) {
            return setBonusNumber();
        }
    }

    private void printStatistics(Map<Winning, Integer> winningCounts, int totalPrize) {
        outputView.printWinningStatistics();
        outputView.printStatistics(winningCounts, totalPrize, user.getPurchaseAmount().getAmount());
    }

    private int calculateTotalPrize(Map<Winning, Integer> winningCounts) {
        int totalPrize = 0;

        for (Winning result : Winning.values()) {
            int count = winningCounts.getOrDefault(result, 0);
            int prize = result.getWinningAmount();
            totalPrize += count * prize;
        }

        return totalPrize;
    }
}
