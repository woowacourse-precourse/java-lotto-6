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
        int count = lotto.calculateSameCount(otherLottoNumbers);
        boolean hasBonus = otherLottoNumbers.hasBonusNumber(bonusNumber);

        if (count == 6) {
            return Ranking.FIRST;
        }
        if (count == 5 && hasBonus) {
            return Ranking.SECOND;
        }
        if (count == 5) {
            return Ranking.THIRD;
        }
            return Ranking.findRankingByCnt(count);
        }
    }
