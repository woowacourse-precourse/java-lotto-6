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

    public Rank calculateRank(Lotto lotto, int bonusNumber) {
        int matchCount = (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();

        boolean hasBonusNumber = lotto.getNumbers().contains(bonusNumber);

        return Rank.valueOf(matchCount, hasBonusNumber);
    }

    public double calculateProfitRate(Map<Rank, Integer> result) {
        int totalPrize = result.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();

        int totalPurchaseAmount = result.values().stream()
                .mapToInt(count -> count * 1000)
                .sum();

        return (totalPrize / (double) totalPurchaseAmount) * 100;
    }
}
