package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.global.Validator;
import lotto.global.util.Util;

public class Input {
    public static Integer getPurchaseAmount() {
        try {
            Integer amount = Util.parseIntOrThrowException(Console.readLine());
            Validator.checkAmount(amount);
            return amount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPurchaseAmount();
        }
    }
}
