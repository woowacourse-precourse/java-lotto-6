package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView {

    private static final String BUY_LOTTO_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String USER_LOTTO_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String USER_LOTTO_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public String inputBuyLottoAmount() {
        System.out.println(BUY_LOTTO_AMOUNT_MESSAGE);
        return Console.readLine();
    }

    public String inputUserLottoNumbers() {
        System.out.println(USER_LOTTO_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public String inputUserBonusNumber() {
        System.out.println(USER_LOTTO_BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
