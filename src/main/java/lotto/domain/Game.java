package lotto.domain;

import lotto.controller.Prompter;
import lotto.view.Message;
import lotto.enums.Ranking;
import lotto.utils.StateChecker;

import java.util.Map;

public class Game {
    private final Message message;
    private final Prompter prompter;
    private final LottoMachine lottoMachine;
    private Player player;
    private WinningLotto winningLotto;
    private LottoResult lottoResult;

    public Game(Message message, Prompter prompter) {
        this.message = message;
        this.prompter = prompter;
        this.lottoMachine = new LottoMachine();
    }

    public void joinPlayer() {
        Money money = prompter.promptMoney();
        Lottos lottos = lottoMachine.issueLottos(money);
        player = new Player(money, lottos);
    }

    public void showIssuedLottos() {
        StateChecker.checkNullState(player);

        message.print(player);
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

    public void showResult() {
        StateChecker.checkNullState(player, winningLotto, lottoResult);

        message.print(player, lottoResult);
    }
}
