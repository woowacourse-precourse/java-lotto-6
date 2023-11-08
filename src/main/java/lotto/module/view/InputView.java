package lotto.module.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.global.utils.Validator;

public class InputView {
    public static Long readPurchaseAmount() {
        String input = readLine();
        Validator.validatePurchaseAmount(input);
        return Long.parseLong(input);
    }
}
