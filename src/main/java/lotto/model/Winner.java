package lotto.model;

public class Winner {
    private final Lotto lotto;
    private final int bonusNumber;

    public Winner(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Ranking winnerMatch(Lotto player) {
        int numberContain = player.countMatch(lotto);

        boolean bonusContain = player.containLottoNumber(bonusNumber);

        return Ranking.ranking(numberContain, bonusContain);
    }
}
