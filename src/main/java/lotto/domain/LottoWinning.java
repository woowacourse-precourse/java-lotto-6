package lotto.domain;

import lotto.constant.ErrorMessage;

import java.util.List;

/**
 * 당첨 번호와 보너스 번호 담고 있는 클래스
 */
public class LottoWinning {
    private Lotto winningNum;
    private LottoNumber bonusNum;

    public LottoWinning() {
    }

    public LottoWinning(Lotto numbers, LottoNumber bonusNum) {
        this.winningNum = numbers;
        this.bonusNum = bonusNum;
    }

    public Lotto getWinningNum() {
        return winningNum;
    }

    public LottoNumber getBonusNum() {
        return bonusNum;
    }
}
