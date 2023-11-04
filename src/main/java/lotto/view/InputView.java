package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.InputValidator;

public class InputView {

    public static String getInput() {
        return InputValidator.validate(Console.readLine());
    }


}
