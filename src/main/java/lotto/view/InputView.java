package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.InputValidator;

public class InputView {
    private static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";

    public String askPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);
        String inputPurchaseAmount = Console.readLine();

        return inputPurchaseAmount;
    }

    public String askWinnigNumbers() {
        return null;
    }

    public int askBonusNumber() {
        return 0;
    }
}

