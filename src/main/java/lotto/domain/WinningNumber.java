package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class WinningNumber {
    private final List<Integer> winningNumber;

    public WinningNumber(String winningNumber) {
        Arrays.asList(winningNumber.split(","));
    }
}
