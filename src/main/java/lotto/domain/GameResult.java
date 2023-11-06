package lotto.domain;

public class GameResult {

    private final WinningLotto winningLotto;
    private final Lottos generatedLottos;

    public GameResult(WinningLotto winningLotto, Lottos generatedLottos) {
        this.winningLotto = winningLotto;
        this.generatedLottos = generatedLottos;
    }


}
