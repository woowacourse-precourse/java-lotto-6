package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public String getLottoPrice() {
        return Console.readLine();
    }

    public List<Integer> getWinningNumbers() {
        String line = Console.readLine();
        List<Integer> winningNumbers = Arrays.stream(line.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .filter(number -> number >= 1 && number <= 45)
                .toList();
        if (winningNumbers.size() != Arrays.stream(line.split(",")).count()) {
            throw new IllegalArgumentException();
        }
        return winningNumbers;
    }
}
