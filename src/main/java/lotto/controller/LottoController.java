package lotto.controller;


import static lotto.util.Util.changeStringToInt;
import static lotto.validator.LottoInputValidator.validateBonusNumber;
import static lotto.view.PrintView.printErrorMessage;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.WinningNumber;
import lotto.util.Util;
import lotto.validator.LottoInputValidator;

public class LottoController {
    public WinningNumber inputWinningNumbers() {
        WinningNumber winningNumber = null;

        while (winningNumber == null) {
            try {
                winningNumber = getValidWinningNumber();
            } catch (IllegalArgumentException e) {
                printErrorMessage(e);
            }
        }

        return winningNumber;
    }

    private WinningNumber getValidWinningNumber() {
        String input = Console.readLine();
        LottoInputValidator.validateWinningNumber(input);
        List<Integer> numbers = Util.changeStringToList(input);
        return new WinningNumber(numbers);
    }

    public int inputBonusNumber() {
        BonusNumber bonusNumber = new BonusNumber();
        boolean validInput = false;

        while (!validInput) {
            try {
                String input = Console.readLine();
                validateBonusNumber(input);
                bonusNumber.setBonusNumber(changeStringToInt(input));
                validInput = true;
            } catch (IllegalArgumentException e) {
                printErrorMessage(e);
            }
        }
        return bonusNumber.getBonusNumber();
    }
}
