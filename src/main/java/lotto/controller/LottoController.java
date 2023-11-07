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
        printStatistics();
    }

    private void beforeStart() {
        try {
            outputView.getInputAmount();
            int purchaseAmount = inputProcessor.getUserInputPurchaseAmount();
            Validation.validatePurchaseAmount(purchaseAmount);
            user = new User(new Amount(purchaseAmount));
            lottoService.buyLottoTickets(user);
            printBuyLotto();
        } catch (IllegalArgumentException e) {
            beforeStart();
        }
    }

    private void printBuyLotto() {
        outputView.printLottoCount(user.getPurchaseAmount().amount() / 1_000);
        for (Lotto lotto : user.getLottos()) {
            outputView.printLottoNumbers(lotto.getNumbers());
        }
    }

    private void setLottoData() {
        lottoData = lottoService.generateWinningNumbers(setWinningNumbers(), setBonusNumber());
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

    private void printStatistics() {
        Map<Winning, Integer> winningCounts = lottoService.getWinningCounts();
        int totalPrize = lottoService.calculateTotalPrize(winningCounts);
        outputView.printWinningStatistics();
        outputView.printStatistics(winningCounts, totalPrize, user.getPurchaseAmount().amount());
    }
}
