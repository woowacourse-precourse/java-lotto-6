package lotto.domain;

import lotto.utils.Reader;

import java.util.List;

public class Game {
    private Player player;
    private Lotto winningLotto;

    public void joinPlayer() {

    }

    public void drawLotto() {

    }

    private int inputMoney() {
        String input = Reader.readLine();
        return Integer.parseInt(input);
    }

    private List<Integer> inputWinningNumbers() {
        return null;
    }

    private int inputBonusNumber() {
        return 0;
    }
}
