package lotto.View.InputValidators;

import lotto.Validator;
import camp.nextstep.edu.missionutils.Console;

public class InputValidator extends Validator {
    protected String userInput;

    public InputValidator(){
        userInput = Console.readLine();
    }
}
