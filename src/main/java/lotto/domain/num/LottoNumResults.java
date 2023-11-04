package lotto.domain.num;

/**
 * 당첨 번호와 보너스 번호들의 모임 클래스
 */
public class LottoNumResults {
    /**
     * 당첨 번호 추첨 번호가 같은지 확인한다.
     *
     * @param num 확인하기 위한 번호
     * @return
     */
    public Boolean isSamePickNum(Integer num) {
        return false;
    }

    /**
     * 보너스 번호가 같은지 확인
     *
     * @param num
     * @return
     */
    public Boolean isSameBonusNum(Integer num) {
        return false;
    }
}
