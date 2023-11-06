package lotto.domain;

import lotto.enums.Ranking;
import lotto.utils.MessageBuilder;
import lotto.utils.StateChecker;
import lotto.utils.Writer;
import lotto.utils.Reader;

import java.util.List;
import java.util.Map;

public class Game {
    private Player player;
    private WinningLotto winningLotto;
    private LottoMachine lottoMachine;

    public void loadLottoMachine() {
        lottoMachine = new LottoMachine();
    }

    public void joinPlayer() {
        Money money = promptMoney();
        Lottos lottos = issueLotto(money);

        player = new Player(money, lottos);

        Writer.print(MessageBuilder.build(player));
    }

    private Money promptMoney() {
        try {
            Writer.promptMoney();
            Money money = new Money(Reader.readInteger());
            Writer.newLine();
            return money;
        } catch (IllegalArgumentException e) {
            Writer.invalidMoneyError();
            Writer.newLine();
            return promptMoney();
        }
    }

    private Lottos issueLotto(Money money) {
        StateChecker.checkNullState(lottoMachine);
        return lottoMachine.issueLottos(money);
    }

    public void promptWinningLotto() {
        try {
            StateChecker.checkNullState(lottoMachine, player);

            Writer.promptWinningNumbers();
            List<Integer> winningNumbers = Reader.readIntegerList(",", -1);
            Lotto lotto = new Lotto(winningNumbers);
            Writer.newLine();
            promptBonusNumber(lotto);
        } catch (IllegalArgumentException e) {
            Writer.invalidWinningNumbersError();
            Writer.newLine();
            promptWinningLotto();
        }
    }

    private void promptBonusNumber(Lotto lotto) {
        try {
            Writer.promptBonusNumber();
            int bonusNumber = Reader.readInteger();
            winningLotto = new WinningLotto(lotto, bonusNumber);
            Writer.newLine();
        } catch (IllegalArgumentException e) {
            Writer.invalidBonusNumberError();
            Writer.newLine();
            promptBonusNumber(lotto);
        }
    }

    public void calculateResult() {
        StateChecker.checkNullState(lottoMachine, player, winningLotto);

        Map<Ranking, Integer> rankingCounts = lottoMachine.rank(player.getLottos(), winningLotto);
        LottoResult lottoResult = new LottoResult(rankingCounts);
        Writer.print(MessageBuilder.build(player, lottoResult));
    }
}
