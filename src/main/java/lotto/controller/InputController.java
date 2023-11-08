package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.view.InputMessage;

public class InputController {
    public static int getPurchasePrice() {
        while (true) {
            try {
                InputMessage.promptPurchasePrice();
                String input = Console.readLine();
                return Validator.validatePurchaseAmount(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> getWinningNumber() {
        InputMessage.promptWinningNumber();
        String input = Console.readLine();
        return Validator.validateWinningNumber(input);
    }

    public static int getBounusNumber(List<Integer> winningNumber) {
        InputMessage.promptBonusNumber();
        String input = Console.readLine();
        return Validator.validateBonusNumber(input, winningNumber);
    }
}
