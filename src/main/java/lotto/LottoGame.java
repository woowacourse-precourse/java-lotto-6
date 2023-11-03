package lotto;

import lotto.exception.ExceptionResolver;
import lotto.validator.InputCommonValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoGame(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startGame() {
        int price = ExceptionResolver.resolveInput(this::inputBuyingPrice);
    }

    private int inputBuyingPrice() {
        String inputPrice = inputView.inputBuyingPrice();
        InputCommonValidator.validate(inputPrice);
        return Integer.parseInt(inputPrice);
    }
}
