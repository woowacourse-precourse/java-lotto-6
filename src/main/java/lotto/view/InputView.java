package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.InputMoneyValidator;

public class InputView {
    public static String inputMoney(){
        OutputView.inputMessage();
        while (true) {
            String moneyInput = Console.readLine();
            try {
                InputMoneyValidator validator = new InputMoneyValidator(moneyInput);
                return moneyInput;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
