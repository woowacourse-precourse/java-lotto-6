package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readMoney() {
        System.out.println(RequestMessage.MONEY.getMessage());
        String money = Console.readLine();
        return money.trim();
    }
}
