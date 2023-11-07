package lotto.controllers;

import static lotto.controllers.InputProcessor.readLine;
import static lotto.model.InputValidator.*;
import static lotto.model.Utilities.inputIntegerParsing;
import static lotto.views.MessageManager.getBonusNumberPromptMessage;
import static lotto.views.MessageManager.getProgramClosePromoptMessage;

public class DongHangLottery {

    public DongHangLottery() {
        winningNumberValidate();
        System.out.println();
        getBonusNumberPromptMessage();
        bonusNumberValidate();
    }
    public void winningNumberValidate() {
        String inputLottoNumber = readLine();
        try {
            validateContainsCommaSeparator(inputLottoNumber);
            validateDuplicateNumber(inputLottoNumber);
            validateWinningNumberInOneToFortyFive(inputLottoNumber);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    public void bonusNumberValidate() {
        String inputWinningNumber = readLine();

        try {
            validateBonusNumberInOneToFortyFive(inputWinningNumber);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}


