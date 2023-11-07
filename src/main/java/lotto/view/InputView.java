package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String GET_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해주세요.";

    public int getPurchaseAmount() {

        System.out.println(GET_PURCHASE_AMOUNT_MESSAGE);
        String input = Console.readLine();

        return Integer.parseInt(input);
    }

}
