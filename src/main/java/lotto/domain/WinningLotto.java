package lotto.domain;

public class WinningLotto {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private static final int WINNING_LOTTO_SIZE = 6;
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }


}
