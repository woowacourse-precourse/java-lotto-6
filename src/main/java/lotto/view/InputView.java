package lotto.view;

import static lotto.constant.message.InputMessage.PURCHASE_PRICE;
import static lotto.constant.ErrorMessage.NON_INTEGER;
import static lotto.constant.message.InputMessage.WINNING_NUMBER;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int requestPurchasePrice() {
        System.out.println(PURCHASE_PRICE);
        return readNumber();
    }

    private int readNumber() {
        while (true) {
            try {
                return Integer.parseInt(Console.readLine());
            } catch (NumberFormatException e) {
                System.out.println(NON_INTEGER);
            }
        }
    }

}
