package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.Validation;

public class Input {

    public static String getData() {
        String data = Console.readLine();
        Validation.validateIsBlank(data);
        return data;
    }

}
