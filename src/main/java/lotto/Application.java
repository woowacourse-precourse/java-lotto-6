package lotto;

import lotto.controller.PlayLotto;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        AppConfig appConfig = new AppConfig();
        PlayLotto playLotto = appConfig.playLotto();
        playLotto.playLotto();
        InputView inputView = appConfig.inputView();
        inputView.close();
    }
}
