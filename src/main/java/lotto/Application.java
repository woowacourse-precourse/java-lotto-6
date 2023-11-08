package lotto;

import lotto.controller.GameController;
import lotto.controller.LottoGameController;
import lotto.model.Game;
import lotto.model.LottoGame;
import lotto.view.GameView;
import lotto.view.LottoGameView;

public class Application {
    public static void main(String[] args) {
        Application.run(LottoGame.class, LottoGameView.class, LottoGameController.class,
                "src/main/resources/messages/lotto-game-messages.properties");
    }

    public static void run(Class<? extends Game> gameClass, Class<? extends GameView> viewClass,
                           Class<? extends GameController> controllerClass, String messagePath) {
        (new Application()).init(gameClass, viewClass, controllerClass, messagePath);
    }

    public void init(Class<? extends Game> gameClass, Class<? extends GameView> viewClass,
                     Class<? extends GameController> controllerClass, String messagePath) {
        Game game;
        GameView gameView;
        GameController gameController;

        try {
            game = gameClass.getConstructor().newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException("게임 인스턴스 생성 오류", e);
        }

        try {
            gameView = viewClass.getDeclaredConstructor(String.class).newInstance(messagePath);
        } catch (Exception e) {
            throw new IllegalArgumentException("게임 뷰 인스턴스 생성 오류", e);
        }

        try {
            gameController = controllerClass.getDeclaredConstructor(Game.class, GameView.class)
                    .newInstance(game, gameView);
        } catch (Exception e) {
            throw new IllegalArgumentException("게임 컨트롤러 인스턴스 생성 오류", e);
        }

        gameController.play();
    }
}
