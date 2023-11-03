package lotto.View;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {

    public String inputPurchaseAmount() {
        String amount = Console.readLine();
        return amount;
    }

    public List<String> inputWinningNumbers() {
        return List.of(Console.readLine().split(","));
    }

    public String inputBonusNumber() {
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }
}
