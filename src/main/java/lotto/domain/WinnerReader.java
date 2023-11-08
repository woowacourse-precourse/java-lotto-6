package lotto.domain;

public class WinnerReader {
    private final Lotto winnerLotto;
    private final Bonus bonus;

    public WinnerReader(Lotto winnerLotto, Bonus bonus) {
        this.winnerLotto = winnerLotto;
        this.bonus = bonus;
    }

    public WinningLottoTable checkLotteries(LottoBundle lottoBundle) {
        return new WinningLottoTable(lottoBundle.checkRankings(winnerLotto, bonus));
    }
}
