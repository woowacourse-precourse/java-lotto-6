package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String PURCHASE_MESSAGE = "구매금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public String inputPurchaseAmount() {
        System.out.println(PURCHASE_MESSAGE);
        return Console.readLine();
    }
    public String inputWinningNum() {
        System.out.println(WINNING_NUMBER_MESSAGE);
        return Console.readLine();
    }
    public String inputBonusNum() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
