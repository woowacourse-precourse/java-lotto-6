package lotto;

public class prizeNumbers {
    private Lotto lotto;
    private BonusNumber bonusNumber;
    public prizeNumbers(Lotto lotto, BonusNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
        validateDuplicateNumber(bonusNumber);
    }
    private void validateDuplicateNumber(BonusNumber bonusNumber) {
        lotto.checkForBonusNumber(bonusNumber);
    }

    public Ranking calculatePrize(Lotto otherLottoNumbers) {
        int cnt = lotto.calculateSameCount(otherLottoNumbers);
        return Ranking.findRankingByCnt(cnt);
    }
}
