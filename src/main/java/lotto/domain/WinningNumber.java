package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {
    private List<Integer> winningNumber;

    public WinningNumber(String userValue) {
        this.winningNumber = Arrays
                .stream(userValue.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
