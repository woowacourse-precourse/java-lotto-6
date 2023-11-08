package lotto.controller.user;

import lotto.constant.LottoRule;
import lotto.controller.handler.ExceptionHandler;
import lotto.model.LottoReceipt;
import lotto.view.InputView;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoPurchase {
    private LottoReceipt lottoReceipt;
    private final InputView inputView;

    public LottoPurchase(LottoReceipt lottoReceipt, InputView inputView) {
        this.lottoReceipt = lottoReceipt;
        this.inputView = inputView;
    }

    private boolean isCorrectAmount(String input) {
        ExceptionHandler exceptionHandler = new ExceptionHandler();

        try {
            exceptionHandler.handlePurchaseAmountException(input);
        } catch (IllegalArgumentException exception) {
            inputView.showInputErrorMessage(exception.getMessage());
            return false;
        }

        return true;
    }

    private int inputAmount() {
        String input;

        while (true) {
            inputView.showAmountInputForm();
            input = readLine().trim();
            inputView.endInput();

            if (isCorrectAmount(input)) {
                break;
            }
        }

        return Integer.parseInt(input);
    }

    public void purchase() {
        int amount = inputAmount();
        int count = amount / LottoRule.PRICE.getValue();

        lottoReceipt.setAmount(amount);
        lottoReceipt.setPurchaseCount(count);
    }
}
