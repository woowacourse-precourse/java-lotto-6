package lotto.view;

import static camp.nextstep.edu.missionutils.Console.*;

public class InputView {

    private static final String PURCHASE_AMOUNT = "구매금액을 입력해 주세요.";
    private static final String WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public String printPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT);
        return readLine();
    }

    public String printWinningNumber() {
        System.out.println(WINNING_NUMBER);
        return readLine();
    }

    public String printBonusNumber() {
        System.out.println(BONUS_NUMBER);
        return readLine();
    }
}
