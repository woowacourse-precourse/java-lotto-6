package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String inputPurchaseAmountMessage = "구입금액을 입력해 주세요.";
    private static final String inputWinningLottoMessage = "당첨 번호를 입력해 주세요.";
    private static final String inputBonusNumberMessage = "보너스 번호를 입력해 주세요.";

    public static String inputPurchaseAmount() {
        System.out.println(inputPurchaseAmountMessage);
        return Console.readLine();
    }

    public static String inputWinningLotto() {
        System.out.println(inputWinningLottoMessage);
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println(inputBonusNumberMessage);
        return Console.readLine();
    }
}
