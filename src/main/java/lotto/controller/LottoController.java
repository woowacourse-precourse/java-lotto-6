package lotto.controller;

import java.util.List;
import lotto.error.ErrorMessage;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int purchaseAmount = getPurchaseAmount();
        int lottoCount = purchaseAmount / 1000;
        for (int i = 0; i < lottoCount; i++) {

        }
    }

    private int getPurchaseAmount() {
        while (true) {
            try {
                outputView.printPurchaseInputMessage();
                int purchaseAmount = inputView.getNumber();
                if (purchaseAmount != 0 && purchaseAmount % 1000 != 0) {
                    throw new IllegalArgumentException();
                }
                return purchaseAmount;
            } catch(IllegalArgumentException e) {
                outputView.printErrorMessage(ErrorMessage.INVALID_LOTTO_PURCHASE_AMOUNT);
            }
        }
    }

    private List<Integer> getWinningNumbers() {
        while (true) {
            try {
                outputView.printWinningNumberInputMessage();
                List<Integer> WinningNumbers = inputView.getNumbers();

            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(ErrorMessage.INVALID_WINNING_NUMBERS);
            }
        }
    }

    private int getBonusNumber() {
        while (true) {
            try {
                outputView.printBonusNumberInputMessage();
                int number = inputView.getNumber();

            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(ErrorMessage.INVALID_BONUS_NUMBER);
            }
        }
    }
}
