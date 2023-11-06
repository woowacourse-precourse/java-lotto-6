package lotto.domain;

import lotto.enums.Ranking;
import lotto.utils.MessageBuilder;
import lotto.utils.StateChecker;
import lotto.utils.Writer;

import java.util.Map;

public class Game {
    private final Prompter prompter;
    private final LottoMachine lottoMachine;
    private Player player;
    private WinningLotto winningLotto;

    public Game(Prompter prompter, LottoMachine lottoMachine) {
        this.prompter = prompter;
        this.lottoMachine = lottoMachine;
    }

    public void joinPlayer() {
        Money money = prompter.promptMoney();
        Lottos lottos = lottoMachine.issueLottos(money);

        player = new Player(money, lottos);

        Writer.print(MessageBuilder.build(player));
    }

    public void generateWinningLotto() {
        StateChecker.checkNullState(player);
        winningLotto = prompter.promptWinningLotto();
    }

    public void calculateResult() {
        StateChecker.checkNullState(player, winningLotto);

        Map<Ranking, Integer> rankingCounts = lottoMachine.rank(player.getLottos(), winningLotto);
        LottoResult lottoResult = new LottoResult(rankingCounts);
        Writer.print(MessageBuilder.build(player, lottoResult));
    }
}
