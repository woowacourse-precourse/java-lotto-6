package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_PURCHASE_AMOUNT_MASSAGE = "구입 금액을 입력해 주세요.";

    public String inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MASSAGE);
        return Console.readLine();
    }

    public int parsePurchaseAmount(String input) {
        return Integer.parseInt(input);
    }
}
