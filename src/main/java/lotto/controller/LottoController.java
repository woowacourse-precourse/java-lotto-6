package lotto.controller;

import lotto.domain.AnswerLotto;
import lotto.domain.UserLotto;
import lotto.view.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidator inputValidator;
    private UserLotto userLotto;
    private AnswerLotto answerLotto;

    public LottoController(InputView inputView, OutputView outputView, InputValidator inputValidator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputValidator = inputValidator;
    }

    public void startLotto() {
        buyLottos();
    }

    private void buyLottos() {
        String input = inputView.getPurchasePrice();
        int purchasePrice = inputValidator.validateNumber(input);
        userLotto = new UserLotto(purchasePrice);
    }
}
