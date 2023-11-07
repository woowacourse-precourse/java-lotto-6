package lotto.util;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputManager {

    public String getBonus() {
        OutputManager.BONUS_PRINT();
        return Console.readLine();
    }

    public List<Integer> getWinningNumbers() {
        OutputManager.WINNING_PRINT();
        String winningNumbers = Console.readLine();
        return Converter.to(winningNumbers);
    }

    public String getMoney() {
        OutputManager.START_PRINT();
        return Console.readLine();
    }
}
