package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public Integer inputInteger() {
        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> inputWinNumbers() {
        return new ArrayList<>(Arrays.stream(Console.readLine().split(","))
                .map(Integer::valueOf)
                .toList());
    }
}
