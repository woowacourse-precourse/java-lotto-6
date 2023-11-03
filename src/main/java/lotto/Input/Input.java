package lotto.Input;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    private static final String WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String BUY_MONEY = "구입금액을 입력해 주세요.";

    public String inputLottoNumber() {
        System.out.println(WINNING_NUMBER);
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println(BONUS_NUMBER);
        return Console.readLine();
    }

    public String inputBuyMoney() {
        System.out.println(BUY_MONEY);
        return Console.readLine();
    }
}
