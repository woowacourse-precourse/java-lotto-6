package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static Integer inputPurchasePrice() {
        String message = InputMessages.PURCHASE_MESSAGE.getMessage();
        System.out.println(message);
        Integer price = Integer.parseInt(input());
        return price;
    }

    public static String input() {
        return Console.readLine();
    }
}
