package io;

import camp.nextstep.edu.missionutils.Console;

import static io.IOMessages.LOTTO_PURCHASE_AMOUNT_MESSAGE;

public class IOHandler {

    public int inputLottoPurchaseAmount() {
        System.out.println(LOTTO_PURCHASE_AMOUNT_MESSAGE.getMessage());

        String input = Console.readLine();
        // TODO: 입력값 검증

        return Integer.parseInt(input);
    }

}
