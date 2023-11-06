package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static final String INPUT_AMOUNT = "구입금액을 입력해 주세요.";

    public int inputAmount() {
        System.out.println(INPUT_AMOUNT);
        String amount = Console.readLine();
        return Integer.parseInt(amount);
    }
}
