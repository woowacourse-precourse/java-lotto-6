package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";

    public static String getPurchaseAmount(){
        printPurchaseMessage();
        return Console.readLine();
    }

    private static void printPurchaseMessage() {
        System.out.println(PURCHASE_MESSAGE);
    }
}
