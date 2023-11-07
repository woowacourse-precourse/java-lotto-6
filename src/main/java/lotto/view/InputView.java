package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.message.InputMessage.*;

public class InputView {

    private final InputValidator validator = new InputValidator();

    public String inputLottoAmount() {
        System.out.println(LOTTO_AMOUNT.getMessage());
        String lottoAmount = Console.readLine();
        validator.validateWholeNumber(lottoAmount);
        return lottoAmount;
    }

    public String inputWinningNumber() {
        System.out.println(WINNING_NUMBER.getMessage());
        String winningNumber = Console.readLine();
        validator.validateWholeNumber(winningNumber);
        return winningNumber;
    }

    public String inputBonusNumber() {
        System.out.println(BONUS_NUMBER.getMessage());
        String bonusNumber = Console.readLine();
        validator.validateWholeNumber(bonusNumber);
        return bonusNumber;
    }
}
