package lotto.model;

import java.util.List;

public class WinningNumber {

    private List<Integer> winningNumbers;

    private WinningNumber(String winningNumbers) {
        List<String> seperatedNumbers = split(winningNumbers);
    }

    public static WinningNumber create(String winningNumbers) {
        return new WinningNumber(winningNumbers);
    }

    private List<String> split(String winningNumbers) {
        return List.of(winningNumbers.split(","));
    }
}
