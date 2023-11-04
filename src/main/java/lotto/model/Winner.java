package lotto.model;

public class Winner {
    private Lotto lotto;
    private int bonusNumber;

    public Winner(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Ranking winnerMatch(Lotto player) {
        // 산 로또에서 일치하는 개수
        int numberContain = player.matchCount(lotto);

        // 보너스에서 일치하는지
        boolean bonusContain = player.containLottoNumber(bonusNumber);

        return Ranking.ranking(numberContain, bonusContain);
    }
}
