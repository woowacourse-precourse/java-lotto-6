package lotto;

import lotto.game.GameService;

public class Application {
    private static final GameService gameService = GameService.getInstance();

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        gameService.runLotto();
    }
}
