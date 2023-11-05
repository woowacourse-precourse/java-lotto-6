package lotto.view;


import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputMessage {
    private static final String ENTER_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";

    public String readLottoPurchaseAmount() {
        System.out.println(ENTER_PURCHASE_AMOUNT);
        return readLine();
    }
}
