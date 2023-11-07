package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int inputMoney() {
        while (true) {
            try {
                String money = Console.readLine();
                return Integer.parseInt(money);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 금액은 숫자를 입력해야 합니다.");
            }
        }
    }


}
