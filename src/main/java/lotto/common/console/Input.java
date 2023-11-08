package lotto.common.console;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static final String READ_PURCHASE_AMOUNT = "구입금액을 입력해주세요.";
    public static final String READ_LOTTO_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String READ_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static String readPurchaseAmount() {
        Output.writeMessage(READ_PURCHASE_AMOUNT);

        return Console.readLine();
    }

    public static String readLottoNumbers() {
        Output.writeMessage(READ_LOTTO_NUMBERS);

        return Console.readLine();
    }

    public static String readBonusNumber() {
        Output.writeMessage(READ_BONUS_NUMBER);

        return Console.readLine();
    }
}
