package lotto.model;

import java.util.List;

public class MatchingLotto {

    private final List<Lotto> lottos;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private int matchedThree = 0;
    private int matchedFour = 0;
    private int matchedFive = 0;
    private int matchedBonus = 0;
    private int matchedSix = 0;

    public MatchingLotto(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        countMatches();
    }

    public void countMatches() {
        for (Lotto lotto : lottos) {
            int matchCount = countMatchingNumbers(lotto, winningNumbers);

            if (matchCount == 6) {
                matchedSix++;
            }
            if (matchCount == 5 && lotto.getNumbers().contains(bonusNumber)) {
                matchedBonus++;
            }
            if (matchCount == 5 && !lotto.getNumbers().contains(bonusNumber)) {
                matchedFive++;
            }
            if (matchCount == 4) {
                matchedFour++;
            }
            if (matchCount == 3) {
                matchedThree++;
            }
        }
    }

    public double calculateLottoReturnRate() {
        int totalPurchaseAmount = lottos.size() * 1000; // 구입 금액
        long totalWinnings = 0;

        totalWinnings += matchedThree * 5000;
        totalWinnings += matchedFour * 50000;
        totalWinnings += matchedFive * 1500000;
        totalWinnings += matchedBonus * 30000000;
        totalWinnings += matchedSix * 2000000000;

        double rate = (double) totalWinnings / totalPurchaseAmount;
        return rate * 100;
    }

    private int countMatchingNumbers(Lotto lotto, List<Integer> winningNumbers) {
        return (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public int getMatchedThree() {
        return matchedThree;
    }

    public int getMatchedFour() {
        return matchedFour;
    }

    public int getMatchedFive() {
        return matchedFive;
    }

    public int getMatchedBonus() {
        return matchedBonus;
    }

    public int getMatchedSix() {
        return matchedSix;
    }

}
