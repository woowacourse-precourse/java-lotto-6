package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class PaymentController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public int getUserPayment() {
        try {
            outputView.requestPayment();
            String userInput = inputView.getUserInput();
            validateInt(userInput);
            return Integer.parseInt(userInput);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return getUserPayment();
        }
    }

    private void validateInt(String userInput) throws IllegalArgumentException {
        try {
            Integer.parseInt(userInput);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }
}
