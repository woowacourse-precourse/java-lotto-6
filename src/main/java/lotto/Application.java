package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    private final static String ASK_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    public static void main(String[] args) {

    }

    private static String askPurchaseAmount() {
        System.out.println(ASK_PURCHASE_AMOUNT_MESSAGE);
        return readLine();
    }
}
