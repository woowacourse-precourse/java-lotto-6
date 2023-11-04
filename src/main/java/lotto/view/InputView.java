package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_LOTTO_AMOUT = "구입금액을 입력해 주세요.";

    public static int inputPurchaseAmount(){
        System.out.println(INPUT_LOTTO_AMOUT);
        return Integer.parseInt(Console.readLine());
    }
}
