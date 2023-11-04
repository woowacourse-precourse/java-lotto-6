package lotto.domain.model;

import lotto.domain.constant.Rank;

/**
 * 로또와 당첨 번호가 얼마나 일치하는지 그 정보를 담기 위한 클래스이다.
 */
public class CorrectResult {

    private final int sameCount; //로또 번호 6개와 당첨 번호 6개 중 일치하는 개수
    private final Boolean existBonus; //로또 번호 6개 중 보너스 번호가 있는지 여부

    public CorrectResult(int sameCount, boolean existBonus) {
        this.sameCount = sameCount;
        this.existBonus = existBonus;
    }

    public boolean compare(Rank rank) {
        return (sameCount == rank.getSameCount()
                && existBonus == rank.getExistBonus());
    }
}
