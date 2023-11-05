package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Controller {
    public void run() {
        int money = convertMoney(inputMoney());
        int lotto = numberOfLotto(money);

        System.out.println(money);
        System.out.println(lotto);
    }

    private String inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    private int convertMoney(String input) {
        return Integer.parseInt(input);
    }

    private int numberOfLotto(int money) {
        return money / 1000;
    }
}
