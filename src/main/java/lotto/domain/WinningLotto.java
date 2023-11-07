package lotto.domain;

public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNumber bonusBall;

    public WinningLotto(Lotto winningLotto, LottoNumber bonusBall) {
        validate(winningLotto, bonusBall);
        this.winningLotto = winningLotto;
        this.bonusBall = bonusBall;
    }

    private void validate(Lotto winningLotto, LottoNumber bonusBall) {
        if (winningLotto.checkBonusballContain(bonusBall)) {
            throw new IllegalArgumentException("[ERROR] 보너스볼이 당첨 번호와 중복되었습니다.");
        }
    }

}
