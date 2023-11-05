package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public InputView() {
    }

    public Long readMoney() {
        try {
            return Long.valueOf(Console.readLine());
        } catch (Exception ex) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> readWinningNumbers() {
        try {
            return Arrays.stream(Console.readLine().split(","))
                .map(Integer::valueOf)
                .toList();
        } catch (Exception ex) {
            throw new IllegalArgumentException();
        }
    }
}
