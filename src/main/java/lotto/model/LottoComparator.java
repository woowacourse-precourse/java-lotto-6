package lotto.model;

public class LottoComparator {
    public static LottoResult getPlace(LottoWithBonus answer, Lotto lotto) {
        Long sameNumbers = answer.countSameNumbers(lotto);
        Boolean hasBonusNumber = answer.checkBonusNumberOf(lotto);
        for (LottoResult result : LottoResult.values()) {
            if (result.getSameNumbers().equals(sameNumbers) && (!result.mustCheckBonus() || hasBonusNumber)) {
                return result;
            }
        }
        return LottoResult.NO_PRIZE;
    }

}
