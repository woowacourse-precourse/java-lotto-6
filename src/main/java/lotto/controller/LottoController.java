package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoData;
import lotto.domain.User;
import lotto.service.LottoService;
import lotto.utils.InputProcessor;
import lotto.view.ExceptionMessages;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

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
    }

    private void beforeStart() {
        beforeStartRecursive();
    }

    private void beforeStartRecursive() {
        try {
            int purchaseAmount = inputProcessor.getUserInputPurchaseAmount();
            user = new User(purchaseAmount);
            lottoService.buyLottoAll(user);
            printBuyLotto();
        } catch (NumberFormatException e) {
            System.out.println(ExceptionMessages.STRING_TO_INTEGER.getMessage());
            beforeStartRecursive();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            beforeStartRecursive();
        }
    }

    private void printBuyLotto() {
        outputView.printLottoCount(user.getPurchaseAmount() / 1_000);
        for (Lotto lotto : user.getLottos()) {
            outputView.printLottoNumbers(lotto.numbers());
        }
    }

    private void setLottoData() {
        lottoData = lottoService.setWinningNumbers(setWinningNumbers(), setBonusNumber());
    }

    private List<Integer> setWinningNumbers() {
        return setWinningNumbersRecursive();
    }

    private List<Integer> setWinningNumbersRecursive() {
        try {
            return inputProcessor.getUserInputWinningNumbers();
        } catch (NumberFormatException e) {
            System.out.println(ExceptionMessages.STRING_TO_INTEGER.getMessage());
            return setWinningNumbersRecursive();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setWinningNumbersRecursive();
        }
    }

    private int setBonusNumber() {
        return setBonusNumberRecursive();
    }

    private int setBonusNumberRecursive() {
        try {
            return inputProcessor.getUserInputBonusNumber();
        } catch (NumberFormatException e) {
            System.out.println(ExceptionMessages.STRING_TO_INTEGER.getMessage());
            return setBonusNumberRecursive();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setBonusNumberRecursive();
        }
    }
}
