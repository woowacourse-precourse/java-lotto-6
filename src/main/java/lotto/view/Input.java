package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Input {
    public int getPurchaseAmount() {
        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> getWinningNumbers() {
        Output.printWinningNumberMessage();
        String inputNumbers = Console.readLine();

        return Arrays.stream(inputNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    public int getBonusNumber() {
        Output.printBonusNumberMessage();
        return Integer.parseInt(Console.readLine());
    }
}
