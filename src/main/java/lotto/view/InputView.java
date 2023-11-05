package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.view.constant.viewMessage.*;
import static lotto.view.validation.InputValidation.inputValidate;

public class InputView {

    public String inputMoney() {
        System.out.print(INPUT_PURCHASE_AMOUNT);
        String input = inputValidate(Console.readLine());
        System.out.println();
        return input;
    }

    public String inputWinningNumbers() {
        System.out.print(INPUT_WINNING_NUMBER);
        String input = inputValidate(Console.readLine());
        System.out.println();
        return input;
    }

    public String inputBonusNumber() {
        System.out.print(INPUT_BONUS_NUMBER);
        String input = inputValidate(Console.readLine());
        System.out.println();
        return input;
    }
}
