package lotto.domain.model;

import lotto.domain.constant.Rank;

/**
 * 로또와 당첨 번호가 얼마나 일치하는지 그 정보를 담기 위한 클래스이다.
 */
public class CorrectResult {

    private final int sameCount; //로또 번호 6개와 당첨 번호 6개 중 일치하는 개수
    private final boolean existBonus; //로또 번호 6개 중 보너스 번호가 있는지 여부

    public CorrectResult(int sameCount, boolean existBonus) {
        this.sameCount = sameCount;
        this.existBonus = existBonus;
    }

    /**
     * 해당 인스턴스의 필드 sameCount, existBonus가 파라미터로 받은 rank와 부합하는지 검사한다.
     * @param rank 등수 정보(1등(Rank.FIRST) ~ 5등(Rank.FIFTH))
     * @return 일치하면 true, 일치하지 않으면 false 반환<br>
     *          ex1) sameCount=3, existBonus=true/false, rank=Rank.FIFTH => true 반환<br>
     *          ex2) sameCount=5, existBonus=true, rank=Rank.THIRD => false 반환
     */
    public boolean compare(Rank rank) {
        if (rank.getExistBonus() == null) {
            return sameCount== rank.getSameCount();
        }
        return (sameCount == rank.getSameCount()
                && existBonus == rank.getExistBonus());
    }
}
