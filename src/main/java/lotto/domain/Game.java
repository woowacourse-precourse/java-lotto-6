package lotto.domain;

import lotto.controller.Prompt;
import lotto.view.Message;

public class Game {
    private final Message message;
    private final Prompt prompt;
    private final LottoMachine lottoMachine;
    private Player player;
    private WinningLotto winningLotto;
    private LottoResult lottoResult;

    public Game(Message message, Prompt prompt, LottoMachine lottoMachine) {
        this.message = message;
        this.prompt = prompt;
        this.lottoMachine = lottoMachine;
    }

    public void run() {
        joinPlayer();
        showIssuedLottos();
        generateWinningLotto();
        calculateResult();
        showResult();
    }

    private void joinPlayer() {
        Money money = prompt.promptMoney();
        Lottos lottos = lottoMachine.issueLottos(money);
        player = new Player(money, lottos);
    }

    private void showIssuedLottos() {
        message.print(player);
    }

    private void generateWinningLotto() {
        winningLotto = prompt.promptWinningLotto();
    }

    private void calculateResult() {
        lottoResult = lottoMachine.rank(player, winningLotto);
    }

    private void showResult() {
        message.print(player, lottoResult);
    }
}
