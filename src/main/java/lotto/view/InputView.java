package lotto.view;

import static lotto.constant.LottoNumber.ZERO;
import static lotto.constant.message.ErrorMessage.NON_INTEGER_MONEY;
import static lotto.constant.message.InputMessage.PURCHASE_PRICE;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static int requestPurchasePrice() {
        System.out.println(PURCHASE_PRICE);

        int money = ZERO.getNumber();
        try {
            Integer.parseInt(readNumber());
        } catch (NumberFormatException e) {
            System.out.println(NON_INTEGER_MONEY);
            requestPurchasePrice();
        }

        return money;
    }

    private static String readNumber() {
        return Console.readLine();
    }

}
