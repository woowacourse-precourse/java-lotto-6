package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.BonusNumValidator;
import lotto.validator.WinningNumValidator;
import lotto.validator.PaymentValidator;
import java.util.List;

public class InputController {
    public static int setPayment() {
        String input = Console.readLine();
        return PaymentValidator.validate(input);
    }

    public static List<Integer> setWinningNum() {
        String input = Console.readLine();
        return WinningNumValidator.validate(input.split(","));
    }
    
    public static int setBonusNum() {
        String input = Console.readLine();
        return BonusNumValidator.validate(input);
    }
}
