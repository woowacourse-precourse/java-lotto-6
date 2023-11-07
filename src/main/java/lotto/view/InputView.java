package lotto.view;

import lotto.Validator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static int getPurchasingPrice() {
        String input = readLine();
        Validator.validateIsInt(input);
        return Integer.parseInt(input);
    }
}
