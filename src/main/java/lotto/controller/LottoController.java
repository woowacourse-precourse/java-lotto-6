package lotto.controller;

import lotto.domain.LottoBuyPrice;
import lotto.view.InputView;
import lotto.view.OutputView;

import static lotto.view.LottoErrorMessage.INPUT_LOTTO_BUY_PRICE_ERROR_MESSAGE;

public class LottoController {

    public void run() {
        LottoBuyPrice lottoBuyPrice = inputLottoBuyPrice();
    }

    private LottoBuyPrice inputLottoBuyPrice() {
        try {
            int inputLottoBuyPrice = InputView.inputNumber();

            return new LottoBuyPrice(inputLottoBuyPrice);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(INPUT_LOTTO_BUY_PRICE_ERROR_MESSAGE);

            return inputLottoBuyPrice();
        }
    }
}
