package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private static final String purchaseAmountInput = "구입금액을 입력해 주세요.";
    private static final String winningNumberInput = "\n당첨 번호를 입력해 주세요.";
    private static final String bonusNumberInput = "\n보너스 번호를 입력해 주세요.";

    public static String PurchaseAmount() {
        System.out.println(purchaseAmountInput);
        return readLine();
    }

    public static String WinningNumber() {
        System.out.println(winningNumberInput);
        return readLine();
    }

    public static String BonusNumber() {
        System.out.println(bonusNumberInput);
        return readLine();
    }
}