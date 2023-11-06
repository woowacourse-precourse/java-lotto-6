package lotto;

import lotto.controller.LottoGameManager;
import lotto.controller.UserInputManager;

public class Application {
    public static void main(String[] args) {
        UserInputManager inputManager = new UserInputManager();
        LottoGameManager gameManager = new LottoGameManager(inputManager);
        gameManager.play();
    }
}
