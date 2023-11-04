package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final static String PURCHASE_MESSAGE = "구입금액을 입력해 주세요";

    public static String getPurchaseAmount(){
        System.out.println(PURCHASE_MESSAGE);
        return Console.readLine();
    }
}
