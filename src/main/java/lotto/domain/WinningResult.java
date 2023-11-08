package lotto.domain;

public class WinningResult {
    private Winning winning;
    private int matchCount;
    public WinningResult(User user, WinningLotto winningLotto, Winning winning) {
        matchCount = user.calculateWinningCount(winning, winningLotto);
        this.winning = winning;
    }

    public Winning getWinning() {
        return winning;
    }


    public int getMatchCount() {
        return matchCount;
    }

    public Money totalProfit() {
        return winning.getAmount().multiply(new Money(matchCount));
    }
}
