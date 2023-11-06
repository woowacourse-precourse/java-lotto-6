package lotto.domain;

import lotto.controller.Prompt;
import lotto.view.Message;
import lotto.enums.Ranking;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

public class Game {
    private final Message message;
    private final Prompt prompt;
    private final LottoMachine lottoMachine;
    private Player player;
    private WinningLotto winningLotto;
    private LottoResult lottoResult;

    public Game(Message message, Prompt prompt) {
        this.message = message;
        this.prompt = prompt;
        this.lottoMachine = new LottoMachine();
    }

    public void joinPlayer() {
        Money money = prompt.promptMoney();
        Lottos lottos = lottoMachine.issueLottos(money);
        player = new Player(money, lottos);
    }

    public void showIssuedLottos() {
        checkNullState(player);

        message.print(player);
    }

    public void generateWinningLotto() {
        checkNullState(player);

        winningLotto = prompt.promptWinningLotto();
    }

    public void calculateResult() {
        checkNullState(player, winningLotto);

        Map<Ranking, Integer> rankingCounts = lottoMachine.rank(player, winningLotto);
        lottoResult = new LottoResult(rankingCounts);
    }

    public void showResult() {
        checkNullState(player, winningLotto, lottoResult);

        message.print(player, lottoResult);
    }

    private void checkNullState(Object ...objects) {
        Arrays.stream(objects).forEach(Objects::requireNonNull);
    }
}
