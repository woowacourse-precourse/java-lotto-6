package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbers inputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = Arrays.stream(Console.readLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        return new WinningNumbers(winningNumbers, bonusNumber);
    }

    public Rank calculateRank(Lotto lotto) {
        int matchCount = (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();

        boolean matchBonus = lotto.getNumbers().contains(bonusNumber);

        return Rank.valueOf(matchCount, matchBonus);
    }

}
