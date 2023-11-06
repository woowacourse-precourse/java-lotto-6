package lotto;

import lotto.controller.Game;
import lotto.domain.Winning;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Winning> winnings = new ArrayList<>();
        winnings.add(new Winning(3, false, 5000));
        winnings.add(new Winning(4, false, 50000));
        winnings.add(new Winning(5, false, 1500000));
        winnings.add(new Winning(5, true, 30000000));
        winnings.add(new Winning(6, false, 2000000000));
        final Game game = new Game(winnings);
        game.start();
    }
}
