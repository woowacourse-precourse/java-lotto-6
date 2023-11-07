package lotto.controllers;

import static lotto.controllers.InputProcessor.readLine;
import static lotto.model.InputValidator.*;
import static lotto.model.Utilities.inputIntegerParsing;
import static lotto.views.MessageManager.getBonusNumberPromptMessage;
import static lotto.views.MessageManager.getProgramClosePromoptMessage;

public class DongHangLottery {
    private String inputLottoNumber;

    public DongHangLottery() {
        winningNumberValidate();
        System.out.println();
        getBonusNumberPromptMessage();
        bonusNumberValidate();
    }
    public void winningNumberValidate() {
        inputLottoNumber = readLine();
        try {
            validateContainsCommaSeparator(inputLottoNumber);
            validateDuplicateNumber(inputLottoNumber);
            validateWinningNumberInOneToFortyFive(inputLottoNumber);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    public void bonusNumberValidate() {
        inputLottoNumber = readLine();
    }
}


