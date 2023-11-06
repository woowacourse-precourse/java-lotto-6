package lotto;

import lotto.domain.Amount;
import lotto.domain.WinningNumber;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

import java.util.Arrays;
import java.util.List;

import static lotto.constant.LottoConstant.LOTTO_NUMBER_SEPARATER;
import static lotto.constant.LottoErrorMessage.*;

public class LottoSimulation {
    private final LottoOutputView outputView = new LottoOutputView();
    private final LottoInputView inputView = new LottoInputView(outputView);

    public void execute() {
        Amount amount = readPurchaseAmount();
        WinningNumber  winningNumber = readWinningNumber();
        readBonusNumber(winningNumber);
    }

    private Amount readPurchaseAmount() {
        while (true) {
            try {
                return new Amount(Integer.parseInt(inputView.readPurchaseAmount()));
            } catch (IllegalArgumentException e) {
                outputView.printMessage(PURCHASE_AMOUNT_ERROR_MESSAGE);
            }
        }
    }

    private WinningNumber readWinningNumber() {
        while (true) {
            try {
                return new WinningNumber(stringToNumberList(inputView.readWinningNumber()));
            } catch (IllegalArgumentException e) {
                if (e.getMessage().equals(LOTTO_LENGTH_ERROR_MESSAGE)) {
                    outputView.printMessage(LOTTO_LENGTH_ERROR_MESSAGE);
                }
                if (e.getMessage().equals(LOTTO_NUMBER_ERROR_MESSAGE)) {
                    outputView.printMessage(LOTTO_NUMBER_ERROR_MESSAGE);
                }
            }
        }
    }

    private void readBonusNumber(WinningNumber winningNumber) {
        while (true) {
            try {
                winningNumber.setBonusNumber(Integer.parseInt(inputView.readBounsNumber()));
                break;
            } catch (IllegalArgumentException e) {
                outputView.printMessage(LOTTO_NUMBER_ERROR_MESSAGE);
            }
        }
    }

    private List<Integer> stringToNumberList(String input) {
        return Arrays.stream(input.split(LOTTO_NUMBER_SEPARATER))
                .map(Integer::parseInt)
                .toList();
    }
}
