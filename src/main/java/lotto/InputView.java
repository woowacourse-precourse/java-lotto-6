package lotto;

import camp.nextstep.edu.missionutils.Console;

import static lotto.OutputView.printRequestMoney;

public class InputView {
    public static String inputRequestMoney() {
        printRequestMoney();
        return Console.readLine();
    }
}
