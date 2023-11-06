package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ErrorMsg;
import lotto.exception.UserInputException;

public class InputView {

    public int parseInputFromUserInteger() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException ex) {
            throw new UserInputException(ErrorMsg.ERROR_INPUT_NOT_NUMBER.getMsg());
        }
    }
}
