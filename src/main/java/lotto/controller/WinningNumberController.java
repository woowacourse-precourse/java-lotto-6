package lotto.controller;

import java.util.List;
import lotto.domain.ConvertingWinningNumber;
import lotto.validator.InputValidator;
import lotto.validator.Lotto;
import lotto.validator.NumberInputValidator;
import lotto.validator.WinningNumberInputValidator;
import lotto.view.WinningNumberInput;

public class WinningNumberController {

    private static final String ENTER_WINNING_NUMBER = "\n당첨 번호를 입력해 주세요.";
    private final InputValidator numberInputValidator = new NumberInputValidator();
    private final InputValidator winningNumberInputValidator = new WinningNumberInputValidator(numberInputValidator);
    private final WinningNumberInput winningNumberInput = new WinningNumberInput(winningNumberInputValidator);
    private final BonusNumberController bonusNumberController = new BonusNumberController();
    private final ConvertingWinningNumber convertingWinningNumber = new ConvertingWinningNumber();
    public static List<Integer> convertingWinningNumbers;

    public void start() {
        System.out.println(ENTER_WINNING_NUMBER);
        String winningNumber = winningNumberInput.readLine();
        convertingWinningNumbers = convertingWinningNumber.convertingWinningNumber(winningNumber);
        Lotto lotto = new Lotto(convertingWinningNumbers);
        bonusNumberController.start();
    }

}
