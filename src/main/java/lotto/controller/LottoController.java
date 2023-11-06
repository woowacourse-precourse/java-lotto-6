package lotto.controller;

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
        setWinningNumbers();
    }

    private void beforeStart() {
        beforeStart(0);
    }

    private void beforeStart(int attempt) {
        try {
            checkAttemptExceeded(attempt, 3);
            int purchaseAmount = inputProcessor.getUserInputPurchaseAmount();
            user = new User(purchaseAmount);
            lottoService.buyLottoAll(user);
            printBuyLotto();
        } catch (NumberFormatException e) {
            System.out.println(ExceptionMessages.STRING_TO_INTEGER.getMessage());
            beforeStart(attempt + 1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            beforeStart(attempt + 1);
        }
    }

    private void checkAttemptExceeded(int currentAttempt, int maxAttempt) {
        if (currentAttempt >= maxAttempt) {
            ExceptionMessages.INPUT_ATTEMPT_EXCEEDED_MESSAGE.throwException();
        }
    }

    private void printBuyLotto() {
        outputView.printLottoCount(user.getPurchaseAmount() / 1_000);
        for (Lotto lotto : user.getLottos()) {
            outputView.printLottoNumbers(lotto.numbers());
        }
    }

    private void setWinningNumbers() {
        lottoData = lottoService.setWinningNumbers(inputProcessor.getUserInputWinningNumbers(),
                inputProcessor.getUserInputBonusNumber());
    }
}
