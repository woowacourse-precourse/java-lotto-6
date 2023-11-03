package lotto;

import static lotto.Notice.*;

public class Application {
    public static void main(String[] args) {

        View.printMessage(ASK_BUDGET);
        String lottoBudgetInput = View.getUserInput();
        Integer budget = Convertor.convertInputToInteger(lottoBudgetInput);

        View.printMessage(ASK_WINNING_NUMBERS);
        String winningNumbersInput = View.getUserInput();
        String[] winningNumbersArray = Convertor.splitInput(winningNumbersInput);
        Convertor.convertToList(winningNumbersArray);

        Convertor.convertToList(winningNumbersArray);
        View.printMessage(ASK_BONUS_NUMBERS);
        String bonusNumberInput = View.getUserInput();
        Integer bonusNumberTemp = Convertor.convertInputToInteger(bonusNumberInput);
    }

}
