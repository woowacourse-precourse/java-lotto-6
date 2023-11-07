package lotto.util;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static lotto.util.OutputManager.*;

public class InputManager {

    public String getBonus() {
        OutputManager.BONUS_PRINT();
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        OutputManager.WINNING_PRINT();
        String winningNumbers = Console.readLine();
        List<Integer> integers = Converter.to(winningNumbers);
        return integers;
    }

    public static String getMoney() {
        OutputManager.START_PRINT();
        String stringMoney = Console.readLine();
        return stringMoney;
    }
}
