package lotto;

import camp.nextstep.edu.missionutils.Console;

import static lotto.OutputView.printRequestMoney;

public class InputView {
    public static void inputRequestMoney() {
        printRequestMoney();
        String inputMoney = Console.readLine();
        new Money(inputMoney);
    }
}
