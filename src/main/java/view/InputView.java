package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";

    public int inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        String money = Console.readLine();
        validateMoney(money);
        return Integer.parseInt(money);
    }

    private void validateMoney(String money) {
        
    }
}
