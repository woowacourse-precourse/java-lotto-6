package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.input.InputValidator;
import lotto.view.message.view.ProcessMessage;

public class InputView {
    private final InputValidator inputValidator = new InputValidator();

    public String InputBudget(){
        System.out.print(ProcessMessage.PLEASE_INPUT_BUDGET.getMessage());
        String budget = input();
        inputValidator.validateInputBudgetIsNumber(budget);
        return budget;
    }

    public String InputWinningNumbers(){
        System.out.print(ProcessMessage.PLEASE_INPUT_WINNING_NUMBERS.getMessage());
        String winningNumbers = input();
        inputValidator.validateInputWinningNumbers(winningNumbers);
        return winningNumbers;
    }

    public String InputBonusNumber(){
        System.out.print(ProcessMessage.PLEASE_INPUT_BONUS_NUMBER.getMessage());
        String bonusNumber = input();
        inputValidator.validateInputBonusNumber(bonusNumber);
        return bonusNumber;
    }

    public void displayLottos(int lottosSize, String lottosForDisplay){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(ProcessMessage.PURCHASE_LOTTO.getMessage(),lottosSize));
        sb.append(lottosForDisplay);
        System.out.print(sb);
    }

    public String input(){
        return Console.readLine();
    }
}
