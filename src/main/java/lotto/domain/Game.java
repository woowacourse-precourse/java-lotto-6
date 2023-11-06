package lotto.domain;

import lotto.enums.Ranking;
import lotto.utils.MessageBuilder;
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
        try {
            checkMachineLoad();

            Writer.promptMoney();
            player = new Player(Reader.readInteger());
            Writer.newLine();
        } catch (IllegalArgumentException e) {
            Writer.invalidMoneyError();
            Writer.newLine();
            joinPlayer();
        }
    }

    public void issueLotto() {
        checkMachineLoad();
        checkPlayerJoin();

        List<Lotto> issuedLottos = lottoMachine.issueLottos(player.getMoney());
        player.addLottos(issuedLottos);
        Writer.print(MessageBuilder.build(player));
    }

    public void drawWinningLotto() {
        try {
            checkMachineLoad();
            checkPlayerJoin();

            Writer.promptWinningNumbers();
            List<Integer> winningNumbers = Reader.readIntegerList(",", -1);
            Lotto lotto = new Lotto(winningNumbers);
            Writer.newLine();
            drawBonusNumber(lotto);
        } catch (IllegalArgumentException e) {
            Writer.invalidWinningNumbersError();
            Writer.newLine();
            drawWinningLotto();
        }
    }

    private void drawBonusNumber(Lotto lotto) {
        try {
            Writer.promptBonusNumber();
            int bonusNumber = Reader.readInteger();
            winningLotto = new WinningLotto(lotto, bonusNumber);
            Writer.newLine();
        } catch (IllegalArgumentException e) {
            Writer.invalidBonusNumberError();
            Writer.newLine();
            drawBonusNumber(lotto);
        }
    }

    public void findResult() {
        checkMachineLoad();
        checkPlayerJoin();
        checkWinningLottoDraw();

        Map<Ranking, Integer> rankingCounts = lottoMachine.rank(player.getLottos(), winningLotto);
        LottoResult lottoResult = new LottoResult(rankingCounts);
        Writer.print(MessageBuilder.build(player, lottoResult));
    }

    private void checkMachineLoad() {
        if (lottoMachine == null) {
            throw new IllegalStateException();
        }
    }

    private void checkPlayerJoin() {
        if (player == null) {
            throw new IllegalStateException();
        }
    }

    private void checkWinningLottoDraw() {
        if (winningLotto == null) {
            throw new IllegalStateException();
        }
    }
}
