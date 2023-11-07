package lotto.controller;

import lotto.model.User;
import lotto.service.InputProcess;
import lotto.service.WinningNumbersValidator;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    InputProcess inputProcess = new InputProcess();
    WinningNumbersValidator winningNumbersValidator = new WinningNumbersValidator();

    public List<String> getInputOfWinningNumbers() {
        return inputProcess.getWinningNumber();
    }

    public List<String> inputWinningNumbers() {
        List<String> winningNumbers = new ArrayList<>();
        boolean check = false;
        while (!check) {
            winningNumbers = getInputOfWinningNumbers();
            check = winningNumbersValidator.checkWinningNumber(winningNumbers);
        }
        return winningNumbers;
    }

    public String getInputOfBonusNumber() {
        return inputProcess.getBonusNumber();
    }

    public int saveBonusNumber(List<String> winningNumbers) {
        String bonusNumber = null;
        boolean check = false;
        while (!check) {
            bonusNumber = getInputOfBonusNumber();
            check = winningNumbersValidator.checkBonusNumber(bonusNumber, winningNumbers);
        }
        return Integer.parseInt(bonusNumber);
    }

    public User saveWinningNumbers() {
        List<String> userWinningNumbers = inputWinningNumbers();
        int bonusNumber = saveBonusNumber(userWinningNumbers);
        return new User(userWinningNumbers, bonusNumber);
    }
}
