package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputHandler {

    public List<Integer> getWinningNumber() {
        List<Integer> winningNumber = Arrays.stream(Console.readLine().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return winningNumber;
    }

    public int getInputNumber() {
        return Integer.parseInt(Console.readLine());
    }
}
