package lotto.domain;

public class WinningResult {
    /**
     * - 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
     *     - 1등: 6개 번호 일치 / 2,000,000,000원
     *     - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
     *     - 3등: 5개 번호 일치 / 1,500,000원
     *     - 4등: 4개 번호 일치 / 50,000원
     *     - 5등: 3개 번호 일치 / 5,000원
     */
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
