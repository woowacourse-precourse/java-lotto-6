package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Controller {
    public void run() {
        int money = convertMoney(inputMoney());
        System.out.println(money);
    }

    private String inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    private int convertMoney(String input) {
        return Integer.parseInt(input);
    }
}
