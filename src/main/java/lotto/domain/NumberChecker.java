package lotto.domain;

public class NumberChecker {
    private final Lotto winningLotto;
    private final Bonus bonus;

    private NumberChecker(final Lotto winningLotto, final Bonus bonus) {
        this.winningLotto = winningLotto;
        this.bonus = bonus;
    }

    public static NumberChecker from(final Lotto winningLotto, final Bonus bonus) {
        return new NumberChecker(winningLotto, bonus);
    }

    public LottoStatistics getLottoResult(final Lottos lottoTicket, final Buyer buyer) {
        return LottoStatistics.from(lottoTicket, winningLotto, bonus, buyer);
    }
}
