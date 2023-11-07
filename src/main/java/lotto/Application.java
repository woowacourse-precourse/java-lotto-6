package lotto;

import lotto.configuration.AppConfig;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        AppConfig appConfig = new AppConfig();
        GameManager gameManager = appConfig.gameManager();
        gameManager.play();
    }
}
