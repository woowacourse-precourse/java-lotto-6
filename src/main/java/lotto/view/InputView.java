package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_MONEY_TO_BUY = "구입금액을 입력해 주세요.";

    public static String inputMoneyToBuyMessage(){
        System.out.println(INPUT_MONEY_TO_BUY);
        return Console.readLine();
    }
}
