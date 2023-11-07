package lotto;

import camp.nextstep.edu.missionutils.Console;

public class PlayerInput {
    //금액 입력받기
    public int InputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());
        return money;
    }
}
