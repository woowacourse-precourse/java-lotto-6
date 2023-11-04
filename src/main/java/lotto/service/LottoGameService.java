package lotto.service;

import static lotto.utils.InputException.NOT_DIGIT_FORM;

import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;

public class LottoGameService {
    private final ConsoleInputView inputView;
    private final ConsoleOutputView outputView;

    public LottoGameService(ConsoleInputView inputView, ConsoleOutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public int readPurchaseAmountFromBuyer() {
        outputView.requestPurchaseAmount();
        try {
            return inputView.readPurchaseAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(NOT_DIGIT_FORM.getMessage());
            return readPurchaseAmountFromBuyer();
        }
    }
}
