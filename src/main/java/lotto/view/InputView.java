package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Validation;

public class InputView {
    private static final String USER_INPUT_BUY_ACCOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    public static int inputBuyLottoMoney() {
        System.out.println(USER_INPUT_BUY_ACCOUNT_MESSAGE);
        String inputBuyLottoMoney = Console.readLine();
        Validation.validateIsNotNumber(inputBuyLottoMoney);
        return convertStringToInt(inputBuyLottoMoney);
    }

    private static int convertStringToInt(String input) {
        return Integer.parseInt(input);
    }
}
