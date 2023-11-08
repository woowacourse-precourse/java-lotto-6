package lotto;

import lotto.domain.Domain;
import lotto.gameplayer.GamePlayer;

public class Application {
    public static void main(String[] args) {
        GamePlayer gamePlayer = new GamePlayer(new Domain());
        gamePlayer.run();
    }
}
