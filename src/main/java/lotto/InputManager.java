package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int moneyInput = Integer.parseInt(Console.readLine());
        return moneyInput;
    }
}
