package lotto.domain;

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

    public boolean sameThree() {
        return (sameCount == 3);
    }

    public boolean sameFour() {
        return (sameCount == 4);
    }

    public boolean sameFiveNotBonus() {
        return (sameCount == 5 && !existBonus);
    }

    public boolean sameFiveBonus() {
        return (sameCount == 5 && existBonus);
    }

    public boolean sameSix() {
        return (sameCount == 6);
    }
}
