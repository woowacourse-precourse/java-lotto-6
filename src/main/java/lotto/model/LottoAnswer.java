package lotto.model;

public class LottoAnswer {

    private final Lotto answer;
    private final BonusNumber bonusNumber;

    public LottoAnswer(Lotto answer, BonusNumber bonusNumber) {
        this.answer = answer;
        this.bonusNumber = bonusNumber;
    }

    public Rank getRankOf(Lotto lotto) {
        int difference = answer.getDifferenceBetween(lotto);
        boolean containsBonusNumber = lotto.isContainBonusNumber(bonusNumber);
        return Rank.findBy(difference, containsBonusNumber);
    }
}
