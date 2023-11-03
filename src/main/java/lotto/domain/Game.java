package lotto.domain;

import lotto.utils.Logs;
import lotto.utils.Reader;

import java.util.Arrays;
import java.util.List;

public class Game {
    private Player player;
    private WinningLotto winningLotto;

    public void joinPlayer() {
        Logs.inputMoney();
        player = new Player(inputMoney());
        Logs.newLine();

        player.issueLotto();
        Logs.print(player.issuedLottos());
    }

    public void drawWinningLotto() {
        Logs.inputWinningNumbers();
        List<Integer> winningNumbers = inputWinningNumbers();
        Logs.newLine();

        Logs.inputBonusNumber();
        int bonusNumber = inputBonusNumber();
        Logs.newLine();

        winningLotto = new WinningLotto(winningNumbers, bonusNumber);
    }

    public void findResult() {
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
}
