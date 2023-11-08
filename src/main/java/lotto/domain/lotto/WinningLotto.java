package lotto.domain.lotto;

public class WinningLotto {

    private final Lotto winningLotto;

    public WinningLotto(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public void validateIsDuplicate(int bonusNumber) {
        if (winningLotto.isDuplicate(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 중복된 입력입니다.");
        }
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }
}