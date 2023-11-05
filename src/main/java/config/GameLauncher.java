package config;

import view.InputView;

public class GameLauncher {

    public static void run() {
        GameConfig config = GameConfig.getInstance();
        InputView inputView = config.inputView();

        inputView.inputPayment();
        inputView.inputWinNumber();
        inputView.inputBonusNumber();
    }

}
