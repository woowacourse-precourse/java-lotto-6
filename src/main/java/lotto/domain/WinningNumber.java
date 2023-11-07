package lotto.domain;

public class WinningNumber {
    private final Lotto winningLotto;
    private final Integer bonusNumber;

    public WinningNumber(Lotto winningLotto, Integer bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public void validate(Lotto winningLotto, Integer bonusNumber)
            throws IllegalArgumentException {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 보너스 번호가 포함될 수 없습니다.");
        }
    }
}
