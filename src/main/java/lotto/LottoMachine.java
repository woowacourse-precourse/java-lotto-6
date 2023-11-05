package lotto;

import static java.lang.Integer.parseInt;

import camp.nextstep.edu.missionutils.Console;

public class LottoMachine {

    private int money;

    private void insertMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        money = parseInt(Console.readLine());
    }

}
