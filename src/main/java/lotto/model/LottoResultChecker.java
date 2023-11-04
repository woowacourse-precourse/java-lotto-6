package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoResultChecker {
    private final List<Integer> winningNumbers;

    public LottoResultChecker (String winningNumbers) {
        this.winningNumbers = splitWinningNumbers(winningNumbers);
    }

    private List<Integer> splitWinningNumbers(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
