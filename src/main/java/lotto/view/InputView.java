package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public Integer inputPurchaseAmount() {
        String amount = Console.readLine();
        return Integer.valueOf(amount);
    }

    public String inputWinningNumbers() {
        String winningNumbers = Console.readLine();
        return winningNumbers;
    }

    public Integer inputBonusNumbers() {
        String bonusNumber = Console.readLine();
        return Integer.valueOf(bonusNumber);
    }
}
