package lotto.View.InputValidators;

import lotto.Validator;
import camp.nextstep.edu.missionutils.Console;

public class InputValidator extends Validator {
    protected String userInput;

    protected void userInputReadLine(){
        userInput = Console.readLine();
    }
}
