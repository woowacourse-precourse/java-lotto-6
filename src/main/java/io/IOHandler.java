package io;

import camp.nextstep.edu.missionutils.Console;

import static io.IOMessages.LOTTO_PURCHASE_AMOUNT_MESSAGE;

public class IOHandler {

    private final InputValidator validator = new InputValidator();

    public int inputLottoPurchaseAmount() {
        System.out.println(LOTTO_PURCHASE_AMOUNT_MESSAGE.getMessage());

        String input = Console.readLine();
        validator.validateLottoPurchaseAmount(input);

        return Integer.parseInt(input);
    }

}
