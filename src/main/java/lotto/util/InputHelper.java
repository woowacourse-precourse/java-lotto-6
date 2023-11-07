package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.WinningNumbers;
import lotto.io.InputAdaptor;
import lotto.io.OutputAdaptor;

import java.util.List;

public class InputHelper {

    public static int numOfLottoToBuy() {
        try {
            return LottoGenerator.calculateNumOfLotto(inputPurchasePrice());
        } catch (IllegalArgumentException e) {
            return numOfLottoToBuy();
        }
    }

    private static int inputPurchasePrice() {
        try {
            OutputAdaptor.displayMessageToPromptToInputPurchasePrice();
            return InputAdaptor.readPurchasePrice();
        } catch (IllegalArgumentException e) {
            return inputPurchasePrice();
        }
    }

    public static WinningNumbers winningNumbers() {
        Lotto winningNumbers = getWinningNumbersWithoutBonusNumber();
        return getWinningNumbersWithBonusNumber(winningNumbers);
    }

    private static Lotto getWinningNumbersWithoutBonusNumber() {
        try {
            return new Lotto(inputWinningNumbers());
        } catch (IllegalArgumentException e) {
            return getWinningNumbersWithoutBonusNumber();
        }
    }

    private static List<Integer> inputWinningNumbers() {
        try {
            OutputAdaptor.displayMessageToPromptToInputWinningNumbers();
            return InputAdaptor.readWinningNumbers();
        } catch (IllegalArgumentException e) {
            return inputWinningNumbers();
        }
    }

    private static WinningNumbers getWinningNumbersWithBonusNumber(Lotto winningNumbers) {
        try {
            return new WinningNumbers(winningNumbers, inputBonusNumber());
        } catch (IllegalArgumentException e) {
            return getWinningNumbersWithBonusNumber(winningNumbers);
        }
    }

    private static int inputBonusNumber() {
        try {
            OutputAdaptor.displayMessageToPromptToInputBonusNumber();
            return InputAdaptor.readBonusNumber();
        } catch (IllegalArgumentException e) {
            return inputBonusNumber();
        }
    }
}
