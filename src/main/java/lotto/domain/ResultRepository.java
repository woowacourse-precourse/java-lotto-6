package lotto.domain;

public class ResultRepository {
    private int numberOfCorrect;
    private boolean hitBonusNumber;

    public ResultRepository(WinningLotto winningLotto, Lotto lotto) {
        numberOfCorrect = lotto.compareTo(winningLotto.winningLotto);
        hitBonusNumber = lotto.contains(winningLotto.bonusNumber);
    }

    public Rank getRank() {
        return Rank.getRank(numberOfCorrect, hitBonusNumber);
    }
}
