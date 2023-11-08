package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public static int readPurchaseAmount() {
        OutputView.printLottoPurchaseAmountPrompt();
        return Integer.parseInt(Console.readLine());
    }

    public static List<Integer> readWinningNumbers() {
        OutputView.printWinningNumbersPrompt();
        return Arrays.stream(Console.readLine().split(","))
            .map(Integer::parseInt)
            .toList();
    }

    public static int readBonusNumber() {
        OutputView.printBonusNumberPrompt();
        return Integer.parseInt(Console.readLine());
    }
}
