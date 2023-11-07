package lotto.controllers;

import static lotto.controllers.InputProcessor.readLine;
import static lotto.model.InputValidator.*;
import static lotto.model.Utilities.inputIntegerParsing;
import static lotto.views.MessageManager.getProgramClosePromoptMessage;

public class DongHangLottery {
    private String inputLottoNumber;

    public DongHangLottery() {
        initialize();
    }
    public void initialize() {
        inputLottoNumber = readLine();
        try {
            validateContainsCommaSeparator(inputLottoNumber);
            validateDuplicateNumber(inputLottoNumber);
            validateWinningNumberInOneToFortyFive(inputLottoNumber);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}


