package lotto.view;

import camp.nextstep.edu.missionutils.Console;
public class InputView {
    private static final String REQUIRE_PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String REQUIRE_WINNING_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String REQUIRE_BONUS_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    public String requirePurchas() {
        System.out.println(REQUIRE_PURCHASE_MESSAGE);
        return Console.readLine();
    }

    public String requireWinning() {
        System.out.println(REQUIRE_WINNING_MESSAGE);
        return Console.readLine();
    }

    public String requireBonus() {
        System.out.println(REQUIRE_BONUS_MESSAGE);
        return Console.readLine();
    }
}
