package lotto.model;

public class LottoComparator {
    public static LottoRank getPlace(LottoWithBonus answer, Lotto lotto) {
        Long sameNumbers = answer.countSameNumbers(lotto);
        Boolean hasBonusNumber = answer.checkBonusNumberOf(lotto);
        for (LottoRank result : LottoRank.values()) {
            if (result.getSameNumbers().equals(sameNumbers) && (!result.mustCheckBonus() || hasBonusNumber)) {
                return result;
            }
        }
        return LottoRank.NO_PRIZE;
    }

}
