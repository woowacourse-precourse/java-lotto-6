package lotto;

import java.util.List;

public enum Rank {
    FIRST(6, 0, 2000000000, "2,000,000,000원", "6개 일치"),
    SECOND(5, 1, 30000000, "30,000,000원", "5개 일치, 보너스 볼 일치"),
    THIRD(5, 0, 1500000, "1,500,000원", "5개 일치"),
    FOURTH(4, 0, 50000, "50,000원", "4개 일치"),
    FIFTH(3, 0, 5000, "5,000원", "3개 일치");

    private final int matchingNumbers;
    private final int matchingBonusNumbers;
    private final int prizeAmount;
    private final String prizeAmountWon;
    private final String description;

    Rank(int matchingNumbers, int matchingBonusNumbers, int prizeAmount, String prizeAmountWon, String description) {
        this.matchingNumbers = matchingNumbers;
        this.matchingBonusNumbers = matchingBonusNumbers;
        this.prizeAmount = prizeAmount;
        this.prizeAmountWon = prizeAmountWon;
        this.description = description;
    }

    public int getMatchingNumbers() {
        return matchingNumbers;
    }

    public int getMatchingBonusNumber() {
        return matchingBonusNumbers;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public String getDescription() {
        return description;
    }

    public String getPrizeAmountWon() {
        return prizeAmountWon;
    }

    public static Rank checkRank(Lotto lotto, WinningLotto winningLotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> winningNumbers = winningLotto.getNumbers();
        int matchedNumbers = (int) lottoNumbers.stream().filter(winningNumbers::contains).count();
        boolean hasBonusNumber = lottoNumbers.contains(winningLotto.getBonus());

        if (matchedNumbers == Rank.FIRST.getMatchingNumbers()) {
            return Rank.FIRST;
        }
        if (matchedNumbers == Rank.SECOND.getMatchingNumbers() && hasBonusNumber) {
            return Rank.SECOND;
        }
        if (matchedNumbers == Rank.SECOND.getMatchingNumbers()) {
            return Rank.THIRD;
        }
        if (matchedNumbers == Rank.FOURTH.getMatchingNumbers()) {
            return Rank.FOURTH;
        }
        if (matchedNumbers == Rank.FIFTH.getMatchingNumbers()) {
            return Rank.FIFTH;
        }
        return null;
    }
}
