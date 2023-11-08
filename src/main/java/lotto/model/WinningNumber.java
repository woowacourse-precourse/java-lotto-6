package lotto.model;

public class WinningNumber {
    private final int bonusNumber;
    private final Lotto winningNumbers;

    public WinningNumber(int bonusNumber, Lotto winningNumbers) {
        this.bonusNumber = bonusNumber;
        this.winningNumbers = winningNumbers;
    }

    public Rank getRank(Lotto lotto) {
        int correctNum = compareLotto(lotto);
        boolean isBonus = false;

        if (correctNum == 5) {
            isBonus = lotto.contains(bonusNumber);
        }
        return Rank.findWhichRank(correctNum, isBonus);
    }

    private int compareLotto(Lotto lotto) {
        return (int) lotto.toList()
                .stream()
                .filter(winningNumbers::contains)
                .count();
    }
}
