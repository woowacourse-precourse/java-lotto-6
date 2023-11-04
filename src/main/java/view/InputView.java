package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static void inputPurchasePrice() {
        System.out.println(InputMessages.PURCHASE_MESSAGE.getMessage());
        Integer price = Integer.parseInt(input());
        System.out.println(price);
    }

    public static String input() {
        return Console.readLine();
    }
}
