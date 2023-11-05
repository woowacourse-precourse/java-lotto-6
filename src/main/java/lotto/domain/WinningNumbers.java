package lotto.domain;

import java.util.List;

public class WinningNumbers {

    private final List<WinningNumber> winningNumbers;

    public WinningNumbers(List<WinningNumber> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static WinningNumbers createWinningNumbers(List<Integer> numbers) {
        List<WinningNumber> winningNumbers = numbers.stream()
                .map(WinningNumber::new)
                .toList();
        return new WinningNumbers(winningNumbers);
    }

}
