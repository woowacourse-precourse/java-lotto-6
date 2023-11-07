package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.view.ErrorMessage;
import lotto.view.PrintMessage;

public class InputWinningLotto {
    public static WinningLotto setInputWinningLotto() {
        Lotto lotto = InputLotto.setInputLotto();
        PrintMessage.printBonusNumber();
        int bonusNumber = setBonusNumber();
        WinningLotto winningLotto = setWinningLotto(lotto, bonusNumber);
        return winningLotto;
    }

    public static WinningLotto setWinningLotto(Lotto lotto, int bonusNumber) {
        try {
            WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
            return winningLotto;
        } catch (IllegalArgumentException e) {
            ErrorMessage.printErrorMessage(e);
            PrintMessage.printBonusNumber();
            bonusNumber = setBonusNumber();
            return setWinningLotto(lotto, bonusNumber);
        }

    }

    public static int setBonusNumber() {
        try {
            String input = Console.readLine();
            isNumeric(input);
            int bonusNumber = Integer.parseInt(input);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            ErrorMessage.printErrorMessage(e);
            PrintMessage.printBonusNumber();
            return setBonusNumber();
        }

    }

    public static void isNumeric(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUM_ERROR);
        }

    }
}
