package lotto;

import lotto.controller.GameController;

public class Application {

    private final GameController gameController;

    public Application(final AppConfig appConfig) {
        this.gameController = appConfig.gameController;
    }

    public static void main(String[] args) {
        Application application = new Application(AppConfig.getInstance());
        application.run();
    }

    public void run() {
        gameController.run();
    }
}
