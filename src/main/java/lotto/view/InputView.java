package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String askMoney = "구입금액을 입력해 주세요.";
    public static String inputMoney() {
        System.out.println(askMoney);
        return Console.readLine();
    }
}
