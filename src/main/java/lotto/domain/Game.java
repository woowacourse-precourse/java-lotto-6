package lotto.domain;

import lotto.enums.Ranking;
import lotto.utils.StateChecker;

import java.util.Map;

public class Game {
    private final Prompter prompter;
    private final LottoMachine lottoMachine;
    private final Messenger messenger;
    private Player player;
    private WinningLotto winningLotto;
    private LottoResult lottoResult;

    public Game(Prompter prompter, LottoMachine lottoMachine, Messenger messenger) {
        this.prompter = prompter;
        this.lottoMachine = lottoMachine;
        this.messenger = messenger;
    }

    public void joinPlayer() {
        Money money = prompter.promptMoney();
        Lottos lottos = lottoMachine.issueLottos(money);
        player = new Player(money, lottos);
    }

    public void printIssuedLottos() {
        StateChecker.checkNullState(player);
        messenger.print(player);
    }

    public void generateWinningLotto() {
        StateChecker.checkNullState(player);
        winningLotto = prompter.promptWinningLotto();
    }

    public void calculateResult() {
        StateChecker.checkNullState(player, winningLotto);

        Map<Ranking, Integer> rankingCounts = lottoMachine.rank(player, winningLotto);
        lottoResult = new LottoResult(rankingCounts);
    }

    public void printResult() {
        StateChecker.checkNullState(player, winningLotto, lottoResult);
        messenger.print(player, lottoResult);
    }
}
