package ui.input;

import camp.nextstep.edu.missionutils.Console;
import parser.IntegerParser;

import java.util.List;

public class WinningsNumbers {
    public static List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumberInput = Console.readLine();

        IntegerParser parser = new IntegerParser();
        List<Integer> winningNumbers = parser.parseNumbers(winningNumberInput);

        return winningNumbers;
    }
}
