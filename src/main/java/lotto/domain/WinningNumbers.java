package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class WinningNumbers {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    private WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbers inputWinningNumbers() {
        List<Integer> winningNumbers = Arrays.stream(Console.readLine("당첨 번호를 입력해 주세요.").split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int bonusNumber = Integer.parseInt(Console.readLine("보너스 번호를 입력해 주세요."));
        return new WinningNumbers(winningNumbers, bonusNumber);
    }

    public Rank calculateRank(Lotto lotto) {

        return null;
    }
}
