package config;

import camp.nextstep.edu.missionutils.Console;

import view.InputView;

public class GameLauncher {

    public static void run() {
        GameConfig config = GameConfig.getInstance();
        InputView inputView = config.inputView();

        inputView.inputPayment();
        inputView.inputWinNumber();
        inputView.inputBonusNumber();

        Console.close();
    }

}
