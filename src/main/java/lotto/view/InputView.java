package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.BonusNumberRequestDto;
import lotto.dto.MoneyRequestDto;
import lotto.dto.WinningNumbersRequestDto;

public class InputView {

    public static MoneyRequestDto inputMoney() {
        return new MoneyRequestDto(Console.readLine());
    }

    public static WinningNumbersRequestDto inputWinningNumbers() {
        return new WinningNumbersRequestDto(Console.readLine());
    }

    public static BonusNumberRequestDto inputBonusNumber() {
        return new BonusNumberRequestDto(Console.readLine());
    }
}
