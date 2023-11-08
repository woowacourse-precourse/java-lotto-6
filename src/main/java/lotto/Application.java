package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import game.GameService;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        GameService gameService = new GameService();
        gameService.play();
    }
}
