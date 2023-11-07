package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InputException;

public class InputView {

    private final static String READ_PURCHASE_MONEY = "구입금액을 입력해 주세요.";

    public int readPurchaseMoney() {
        System.out.println(READ_PURCHASE_MONEY);
        String purchaseMoney =  Console.readLine();
        validateInteger(purchaseMoney);
        return Integer.parseInt(purchaseMoney);
    }

    public void validateInteger(String str) {
        if(!str.matches("^-?\\d+$")) {
            throw new IllegalArgumentException(InputException.NOT_INTEGER.getExceptionMessage());
        }
    }
}
