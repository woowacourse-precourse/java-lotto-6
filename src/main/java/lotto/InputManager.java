package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
    public int inputMoney() {
        int moneyInput = 0;
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                moneyInput = Integer.parseInt(Console.readLine().replaceAll("\\s", ""));
                InputValidator.checkDivisibleBy1000(moneyInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return moneyInput;
    }
}
