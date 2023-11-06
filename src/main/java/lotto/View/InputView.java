package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_VIEW_LOTTO_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_VIEW_WIN_LOTTO_NUMBER = "당첨 번호를 입력해주세요.";
    private static final String INPUT_VIEW_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public String purchaseLotto() {
        System.out.println(INPUT_VIEW_LOTTO_AMOUNT);
        return Console.readLine();
    }

    public String winLottoNumber() {
        System.out.println(INPUT_VIEW_WIN_LOTTO_NUMBER);
        return Console.readLine();
    }

    public String bonusNumber() {
        System.out.println(INPUT_VIEW_BONUS_NUMBER);
        return Console.readLine();
    }

}
