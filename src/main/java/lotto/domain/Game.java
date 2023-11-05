package lotto.domain;

import lotto.utils.Logs;
import lotto.utils.Reader;

import java.util.Arrays;
import java.util.List;

public class Game {
    private Player player;
    private WinningLotto winningLotto;

    public void joinPlayer() {
        try {
            Logs.inputMoney();
            player = new Player(inputMoney());
            Logs.newLine();
        } catch (IllegalArgumentException e) {
            Logs.inputMoneyERROR();
            Logs.newLine();
            joinPlayer();
        }
    }

    public void issueLotto() {
        checkPlayerJoin();
        player.issueLotto();
        Logs.print(player.issuedLottos());
    }

    public void drawWinningLotto() {
        try {
            checkPlayerJoin();
            Logs.inputWinningNumbers();
            List<Integer> winningNumbers = inputWinningNumbers();
            Lotto lotto = new Lotto(winningNumbers);
            Logs.newLine();
            drawBonusNumber(lotto);
        } catch (IllegalArgumentException e) {
            Logs.inputWinningNumbersERROR();
            Logs.newLine();
            drawWinningLotto();
        }
    }

    private void drawBonusNumber(Lotto lotto) {
        try {
            Logs.inputBonusNumber();
            int bonusNumber = inputBonusNumber();
            winningLotto = new WinningLotto(lotto, bonusNumber);
            Logs.newLine();
        } catch (IllegalArgumentException e) {
            Logs.inputBonusNumberERROR();
            Logs.newLine();
            drawBonusNumber(lotto);
        }
    }

    public void findResult() {
        checkPlayerJoin();
        checkWinningLottoDraw();
        player.findResults(winningLotto);
        player.findTotalPrize();
        Logs.print(player.lottoResults());
    }

    private int inputMoney() {
        String input = Reader.readLine().strip();
        return Integer.parseInt(input);
    }

    private List<Integer> inputWinningNumbers() {
        String input = Reader.readLine();

        List<Integer> winningNumbers = Arrays.stream(input.split(",", -1))
                .map(String::strip)
                .map(Integer::parseInt)
                .toList();

        return winningNumbers;
    }

    private int inputBonusNumber() {
        String input = Reader.readLine().strip();
        return Integer.parseInt(input);
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
