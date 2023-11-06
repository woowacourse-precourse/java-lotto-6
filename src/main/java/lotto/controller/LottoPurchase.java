package lotto.controller;

import lotto.exception.LottoNumberException;
import lotto.view.InputView;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoPurchase {
    private int purchaseAmount;
    private LottoNumberException lottoNumberException;
    private InputView inputView;

    public LottoPurchase() {
        purchaseAmount = 0;

        lottoNumberException = new LottoNumberException();
        inputView = new InputView();
    }

    private boolean isCorrectAmount(String input) {
        try {
            lottoNumberException.validatePositiveInteger(input);
            lottoNumberException.isOutOfIntegerRange(input);
        } catch (IllegalArgumentException exception) {
            inputView.showInputErrorMessage(exception.getMessage());
            return false;
        }

        return true;
    }

    public void inputAmount() {
        String input;

        while (true) {
            inputView.showAmountInputForm();
            input = readLine();

            if (isCorrectAmount(input)) {
                break;
            }
        }

        purchaseAmount = Integer.parseInt(input);
    }
}
