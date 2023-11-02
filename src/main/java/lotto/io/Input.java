package lotto.io;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Input {

    public int getUserAmount() {
        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> getWinningNumbers() {
        return Arrays.stream(Console.readLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int getBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }
}
