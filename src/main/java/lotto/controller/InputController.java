package lotto.controller;

import camp.nextstep.edu.missionutils.Console;

public class InputController {

    Validation validation = new Validation();
    public long purchaseAmount() {

        String input = Console.readLine();
        try {
            validation.purchaseAmount(input);
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            purchaseAmount();
        }

        return Long.parseLong(input);
    }
}
