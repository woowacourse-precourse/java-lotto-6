package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.controller.Validator;

public class InputView {

    public static int getBuyAmount() {
        String playerInput = readLine();

        if (Validator.isBuyAmountValid(playerInput)) {
            return Integer.parseInt(playerInput);
        }

        return -1;
    }
}
