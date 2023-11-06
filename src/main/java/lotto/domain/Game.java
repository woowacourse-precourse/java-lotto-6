package lotto.domain;

import lotto.enums.Ranking;
import lotto.utils.Messages;
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

            Messages.inputMoney();
            player = new Player(Reader.readInteger());
            Messages.newLine();
        } catch (IllegalArgumentException e) {
            Messages.inputMoneyError();
            Messages.newLine();
            joinPlayer();
        }
    }

    public void issueLotto() {
        checkMachineLoad();
        checkPlayerJoin();

        List<Lotto> issuedLottos = lottoMachine.issueLottos(player.getMoney());
        player.addLottos(issuedLottos);
        Messages.print(player);
    }

    public void drawWinningLotto() {
        try {
            checkMachineLoad();
            checkPlayerJoin();

            Messages.inputWinningNumbers();
            List<Integer> winningNumbers = Reader.readIntegerList(",", -1);
            Lotto lotto = new Lotto(winningNumbers);
            Messages.newLine();
            drawBonusNumber(lotto);
        } catch (IllegalArgumentException e) {
            Messages.inputWinningNumbersError();
            Messages.newLine();
            drawWinningLotto();
        }
    }

    private void drawBonusNumber(Lotto lotto) {
        try {
            Messages.inputBonusNumber();
            int bonusNumber = Reader.readInteger();
            winningLotto = new WinningLotto(lotto, bonusNumber);
            Messages.newLine();
        } catch (IllegalArgumentException e) {
            Messages.inputBonusNumberError();
            Messages.newLine();
            drawBonusNumber(lotto);
        }
    }

    public void findResult() {
        checkMachineLoad();
        checkPlayerJoin();
        checkWinningLottoDraw();

        Map<Ranking, Integer> rankingCounts = lottoMachine.rank(player.getLottos(), winningLotto);
        LottoResult lottoResult = new LottoResult(rankingCounts, player.getMoney());
        Messages.print(lottoResult);
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
