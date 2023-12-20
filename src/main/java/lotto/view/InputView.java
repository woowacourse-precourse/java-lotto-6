package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.BonusNumberForm;
import lotto.dto.MoneyForm;
import lotto.dto.WinningNumbersForm;

public class InputView {

    public static MoneyForm inputMoney() {
        return new MoneyForm(Console.readLine());
    }

    public static WinningNumbersForm inputWinningNumbers() {
        return new WinningNumbersForm(Console.readLine().split(","));
    }

    public static BonusNumberForm inputBonusNumber() {
        return new BonusNumberForm(Console.readLine());
    }
}
