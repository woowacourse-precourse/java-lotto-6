package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_Purchase_Amount = "구입금액을 입력해 주세요.";

    public int inputPurchaseAmount() {
        return Integer.parseInt(Console.readLine());
    }

    public int inputWinningNumbers() {
        return Integer.parseInt(Console.readLine());
    }

    public void inputBonusNumber() {

    }
}
