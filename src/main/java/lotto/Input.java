package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    private final static String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    public static String inputPurchaseAmount() {
        System.out.println(INPUT_AMOUNT_MESSAGE);
        return readLine();
    }
}
