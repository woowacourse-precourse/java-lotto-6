package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PRICE_FOR_PURCHASING_LOTTO = "구입금액을 입력해 주세요.";
    private static final String WINNING_LOTTO = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static String inputPriceForPurchasingLotto() {
        System.out.println(PRICE_FOR_PURCHASING_LOTTO);
        return Console.readLine();
    }

    public static String inputWinningLotto() {
        OutputView.newLine();
        System.out.println(WINNING_LOTTO);
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        OutputView.newLine();
        System.out.println(BONUS_NUMBER);
        return Console.readLine();
    }
}