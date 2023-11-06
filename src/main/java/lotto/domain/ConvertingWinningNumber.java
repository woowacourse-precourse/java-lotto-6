package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertingWinningNumber {

    List<Integer> convertingWinningNumber = new ArrayList<>();

    public List<Integer> convertingWinningNumber(String winningNumber) {
        return Arrays.stream(winningNumber.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
