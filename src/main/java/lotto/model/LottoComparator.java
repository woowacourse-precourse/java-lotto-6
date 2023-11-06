package lotto.model;

public class LottoComparator {
    public static LottoRank getPlace(LottoWithBonus answer, Lotto lotto) {
        Long sameNumbers = answer.countSameNumbers(lotto);
        Boolean hasBonusNumber = answer.checkBonusNumberOf(lotto);
        for (LottoRank result : LottoRank.values()) {
            // 주의: LottoRank의 원소 순서에 의존합니다.
            // 여러 Enum의 조건을 동시에 만족한다면, 먼저 확인하는 것을 반환합니다.
            if (result.getSameNumbers().equals(sameNumbers) && (!result.mustCheckBonus() || hasBonusNumber)) {
                return result;
            }
        }
        return LottoRank.NO_PRIZE;
    }

}
