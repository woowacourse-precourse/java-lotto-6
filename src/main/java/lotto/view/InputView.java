package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String askMoneyMessage = "구입금액을 입력해 주세요.";
    public static String askWinningNumbersMessage = "당첨 번호를 입력해 주세요.";
    public static String askBonusNumberMessage = "보너스 번호를 입력해 주세요.";

    public static String inputMoney() {
        System.out.println(askMoneyMessage);
        return Console.readLine();
    }

    public static String inputWinningNumbers() {
        System.out.println(askWinningNumbersMessage);
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println(askBonusNumberMessage);
        return Console.readLine();
    }
}