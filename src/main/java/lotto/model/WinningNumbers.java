package lotto.model;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class WinningNumbers {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbers parseWinningNumbers(String winningNumbersStr) {
        String[] winningNumbersArray = winningNumbersStr.split(",");
        List<Integer> winningNumbers = Arrays.stream(winningNumbersArray)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        if (winningNumbers.size() != 7) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호를 모두 입력하세요.");
        }

        int bonusNumber = winningNumbers.remove(winningNumbers.size() - 1);

        return new WinningNumbers(winningNumbers, bonusNumber);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}