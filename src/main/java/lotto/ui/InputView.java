package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private InputValidator inputValidator = new InputValidator();

    public int getAmount() {
        int amount = 0;
        boolean validInput = false;

        while (!validInput) {
            String input = Console.readLine();
            try {
                amount = inputValidator.validateAmount(input);
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return amount;
    }
}