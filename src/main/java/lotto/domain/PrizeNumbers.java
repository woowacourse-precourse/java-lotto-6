package lotto.domain;

public class PrizeNumbers {
    private Lotto lotto;
    private BonusNumber bonusNumber;

    public PrizeNumbers(Lotto lotto, BonusNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
        validateDuplicateNumber(bonusNumber);
    }

    private void validateDuplicateNumber(BonusNumber bonusNumber) {
        lotto.checkForBonusNumber(bonusNumber);
    }

    public Ranking calculatePrize(Lotto otherLottoNumbers) {
        int count = lotto.calculateSameCount(otherLottoNumbers);
        boolean hasBonus = otherLottoNumbers.hasBonusNumber(bonusNumber);
        return Ranking.findRanking(count, hasBonus);
    }
}
