package lotto;

import lotto.config.AppConfig;

public class LottoGameController {
    public void run() {
        Money money = getMoney();
    }

    public Money getMoney() {
        AppConfig appConfig = new AppConfig();
        InputView inputView = appConfig.inputView();
        return inputView.getMoney();
    }


}
