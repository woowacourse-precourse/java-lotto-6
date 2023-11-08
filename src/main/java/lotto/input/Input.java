package lotto.input;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static void print(InputMessage message) {
        System.out.println(message.getMessage());
    }

    private static void printEnterPurchaseAmount() {
        print(InputMessage.ENTER_PURCHASE_AMOUNT);
    }

    private static void printEnterLottoNumbers() {
        print(InputMessage.ENTER_LOTTO_NUMBERS);
    }

    public static int getPurchaseAmount() {
        printEnterPurchaseAmount();
        String purchaseAmount = Console.readLine();
        InputValidator.isValidPurchaseAmount(purchaseAmount);
        return Integer.parseInt(purchaseAmount);
    }
}
