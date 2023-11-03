package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class inputView {
    private static final String REQUEST_MONEY = "구입금액을 입력해 주세요.";

    public static String getREQUEST_MONEY() {
        System.out.println(REQUEST_MONEY);
        return Console.readLine();
    }
}
