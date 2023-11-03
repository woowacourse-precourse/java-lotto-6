package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Stream;

public class InputView {

    public int inputMoney() {
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

    public List<Integer> inputWinningNumbers() {
        String input = Console.readLine();
        return Stream.of(input.split(","))
                .map(Integer::parseInt)
                .toList();
    }

    public int inputBonusNumber() {
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
