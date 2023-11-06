package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_LOTTO_AMOUNT = "구입 금액을 입력해 주세요.";

    public static String inputPlayerAmount() {
        System.out.println(INPUT_LOTTO_AMOUNT);
        return Console.readLine();
    }

}
