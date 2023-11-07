package lotto.controllers;

import static lotto.controllers.InputProcessor.readLine;
import static lotto.model.InputValidator.*;
import static lotto.views.MessageManager.*;

public class DongHangLottery {
    public static String inputWinningNumber;
    public static String inputBonusNumber;

    public DongHangLottery() {
        winningNumberValidate();
        System.out.println();
        getBonusNumberPromptMessage();
        bonusNumberValidate();
        System.out.println();
        getWinnersCountPromptMessage();
        getHyphenPromptPromptMessage();
    }

    public static String getInputWinningNumber() {
        return inputWinningNumber;
    }

    public static String getInputBonusNumber() {
        return inputBonusNumber;
    }

    public void winningNumberValidate() {
        int maxAttempts = 3;
        int attempts = 0;
        inputWinningNumber = InputProcessor.readLine();

        while (attempts < maxAttempts) {
            try {
                validateWinningNumber(inputWinningNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
                inputWinningNumber = InputProcessor.readLine();
                attempts++;
            }
        }
        if (attempts == maxAttempts) {
            getProgramClosePromoptMessage();
        }
        System.out.println(inputWinningNumber);
    }

    public void bonusNumberValidate() {
        int maxAttempts = 3;
        int attempts = 0;
        inputBonusNumber = readLine();
        while (attempts < maxAttempts) {
            try {
                validateBonusNumberInOneToFortyFive(inputBonusNumber);
                validateDuplicateBonusNumberAndWinningNumber(inputWinningNumber, inputBonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
                inputBonusNumber = readLine();
                attempts++;
            }
        }
        if (attempts == maxAttempts) {
            getProgramClosePromoptMessage();
        }
    }
}


