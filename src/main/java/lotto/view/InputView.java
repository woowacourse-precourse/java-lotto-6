package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public int readPurchaseAmount() {
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

    public List<Integer> readWinningNumbers() {
        String[] input = Console.readLine().split(",");
        return Arrays.stream(input)
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
    public int readBonusNumber() {
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
