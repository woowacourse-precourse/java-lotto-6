package lotto.controller;

import java.util.List;
import lotto.domain.Amount;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoData;
import lotto.domain.User;
import lotto.service.LottoService;
import lotto.utils.InputProcessor;
import lotto.utils.Validation;
import lotto.view.InputView;
import lotto.view.OutputView;

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
        lottoData = lottoService.setWinningNumbers(setWinningNumbers(),setBonusNumber());
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
}
