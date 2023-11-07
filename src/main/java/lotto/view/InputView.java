package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.validator.GlobalValidator.validateBlank;
import static lotto.validator.GlobalValidator.validateNumber;

public class InputView {

    public String purchaseCost(){
        String input = Console.readLine();
        validateBlank(input);
        validateNumber(input);
        return input;
    }
}
