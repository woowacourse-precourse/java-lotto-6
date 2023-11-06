package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    final static String InputMessage = "구매 금액을 입력해주세요.";
    public static String requestPurchaseAmount(){
        System.out.println(InputMessage);
        return Console.readLine();
    }
}
