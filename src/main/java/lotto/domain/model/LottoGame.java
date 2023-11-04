package lotto.domain.model;

public final class LottoGame {
    private static final int FIVE_COUNT = 5;

    private final Lottos lottos;
    private final WinningLotto winningLotto;

    public LottoGame(Lottos lottos, WinningLotto winningLotto) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
    }
}
