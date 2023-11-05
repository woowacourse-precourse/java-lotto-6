package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public int inputMoney() {
        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> inputNumbers() {
        String s = Console.readLine();
        return Arrays.stream(s.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
