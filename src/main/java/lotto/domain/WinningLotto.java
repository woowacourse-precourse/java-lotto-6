package lotto.domain;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonus;

    public WinningLotto(Lotto lotto, int bonus) {
        winningLotto = lotto;
        this.bonus = bonus;
    }

    private void validateNumericValues(int bonus) {

    }

    private void validateNumberRange(int bonus) {

    }

}
