package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String NEW_LINE = "\n";

    public String printMoney() {
        System.out.println(INPUT_MONEY);
        return Console.readLine();
    }

    public String printWiningNumbers() {
        System.out.println(INPUT_WINING_NUMBERS);
        return Console.readLine();
    }

    public String printBonusNumber() {
        System.out.println(NEW_LINE + INPUT_BONUS_NUMBER);
        return Console.readLine();
    }
}
