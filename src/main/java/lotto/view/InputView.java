package lotto.view;

import static lotto.view.utils.GameMessage.INPUT_BONUS_NUMBER;
import static lotto.view.utils.GameMessage.INPUT_MONEY;
import static lotto.view.utils.GameMessage.INPUT_WINNING_NUMBERS;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.InputBonus;
import lotto.dto.InputMoney;
import lotto.dto.InputWinningNumbers;

public class InputView {
    public static InputMoney inputMoney() {
        System.out.println(INPUT_MONEY.getMessage());
        return new InputMoney(Console.readLine());
    }

    public static InputWinningNumbers inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS.getMessage());
        return new InputWinningNumbers(Console.readLine());
    }

    public static InputBonus inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER.getMessage());
        return new InputBonus(Console.readLine());
    }
}
