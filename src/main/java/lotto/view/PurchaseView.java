package lotto.view;


import camp.nextstep.edu.missionutils.Console;
import lotto.constant.PurchaseMessage;

import static lotto.constant.ErrorMessage.*;
import static lotto.constant.PurchaseMessage.ASK_PURCHASE_PRICE;


public class PurchaseView {

    public int requestMoney() {
        printPurchaseMessage(ASK_PURCHASE_PRICE);
        String input = Console.readLine();
        validateMoney(input);
        return parseMoneyAmount(input);
    }

    public int parseMoneyAmount(String input) {
        int money = Integer.parseInt(input);
        return money;
    }

    private void printPurchaseMessage(PurchaseMessage purchaseMessage) {
        System.out.println(purchaseMessage.getMessage());
    }

    private void validateMoney(String input) {
        checkIsNumber(input);
        checkNotNull(input);
        checkNoCommas(input);
    }

    private void checkIsNumber(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(INPUT_STRING.getMessage());
        }
    }

    private void checkNotNull(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY.getMessage());
        }
    }

    private void checkNoCommas(String input) {
        if (input.contains(",")) {
            throw new IllegalArgumentException(NOT_CONTAIN_COMMA.getMessage());
        }
    }


}
