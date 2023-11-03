package lotto.domain;

import lotto.utils.Reader;

import java.util.Arrays;
import java.util.List;

public class Game {
    private Player player;
    private Lotto winningLotto;

    public void joinPlayer() {

    }

    public void drawLotto() {

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
