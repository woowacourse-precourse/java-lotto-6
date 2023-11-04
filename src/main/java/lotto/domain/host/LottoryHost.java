package lotto.domain.host;

public class LottoryHost {
    /**
     * 당첨 번호 추첨을 뽑는다.
     *
     * @param strLine 당첨 번호 문자열
     */
    public void pickWinNum(String strLine) {
    }

    /**
     * 보너스 번호를 뽑는다.
     *
     * @param num
     */
    public void pickBonusNum(String num) {

    }

    /**
     * 중복되는 당첨 번호가 있는지 확인한다.
     *
     * @return
     */
    public Boolean checkDuplicateWinNum(String num) {
        return false;
    }

    /**
     * 중복되는 보너스 번호가 있는지 확인한다.
     *
     * @return
     */
    public Boolean checkDulicateBonusNum(String num) {
        return false;
    }
}
