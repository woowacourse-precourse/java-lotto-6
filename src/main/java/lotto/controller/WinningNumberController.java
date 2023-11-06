package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.ConvertingWinningNumber;
import lotto.validator.InputValidator;
import lotto.validator.NumberInputValidator;
import lotto.validator.WinningNumberInputValidator;
import lotto.view.WinningNumberInput;

public class WinningNumberController {

    private static final String ENTER_WINNING_NUMBER = "\n당첨 번호를 입력해 주세요.";
    InputValidator numberInputValidator = new NumberInputValidator();
    InputValidator winningNumberInputValidator = new WinningNumberInputValidator(numberInputValidator);
    WinningNumberInput winningNumberInput = new WinningNumberInput(winningNumberInputValidator);
    BonusNumberController bonusNumberController = new BonusNumberController();
    ConvertingWinningNumber convertingWinningNumber = new ConvertingWinningNumber();
    List<Integer> convertingWinningNumbers = new ArrayList<>();

    public void start() {
        System.out.println(ENTER_WINNING_NUMBER);
        String winningNumber = winningNumberInput.readLine();
        convertingWinningNumbers = convertingWinningNumber.convertingWinningNumber(winningNumber);
        System.out.println("convertingWinningNumbers = " + convertingWinningNumbers);
        bonusNumberController.start();
    }

}
